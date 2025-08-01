package br.com.afr8799.to_do_list.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.afr8799.to_do_list.users.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
// em FilterTaskAuth dar ctrl . escolher add unimplemented methods
public class FilterTaskAuth extends OncePerRequestFilter{

    @Autowired
    private IUserRepository uiUserRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var servletPath = request.getServletPath();

                if(servletPath.startsWith("/tasks/")) {

                    var Authorization = request.getHeader("Authorization");

                    //decod
                    var authEncoded = Authorization.substring("Basic".length()).trim();
                    //System.out.println(authEncoded);

                    byte[] authDecode = Base64.getDecoder().decode(authEncoded);
                    //System.out.println(authDecode);

                    var authString = new String(authDecode);
                    //System.out.println(authString);

                    String[] credentials = authString.split(":");
                    String username = credentials[0];
                    String password = credentials[1];
                    
                    //System.out.println("Authorization");
                    //System.out.println(username);
                    //System.out.println(password);

                            var user = this.uiUserRepository.findByUsername(username);
                            if(user == null) {
                                response.sendError(401);
                            }else {

                                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                                if(passwordVerify.verified){

                                    request.setAttribute("idUser", user.getId() );
                                    filterChain.doFilter(request, response);
                                }else {
                                    response.sendError(401);
                                }

                                
                            }
                    
                } else {
                    filterChain.doFilter(request, response);
                }

    }

}
