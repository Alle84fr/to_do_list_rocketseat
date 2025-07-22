package br.com.afr8799.to_do_list.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
// em FilterTaskAuth dar ctrl . escolher add unimplemented methods
public class FilterTaskAuth implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Primeiro vem no filtro");
        chain.doFilter(request, response);
    }
    
}
