package br.com.afr8799.to_do_list.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
// em FilterTaskAuth dar ctrl . escolher add unimplemented methods
public class FilterTaskAuth extends OncePerRequestFilter{



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
   
        var Authorization = request.getHeader("Authorization");

        //decod
        var authEncoded = Authorization.substring("Basic".length()).trim();
        System.out.println(authEncoded);

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        System.out.println(authDecode);

        var authString = new String(authDecode);
        System.out.println(authString);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        
        System.out.println("Authorization");
        System.out.println(username);
        System.out.println(password);

        filterChain.doFilter(request, response);
    }


    
}
