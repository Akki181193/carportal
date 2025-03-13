package com.carportal.config;

import com.carportal.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        if(token!=null && token.startsWith("Bearer ")){
            String jwtToken = token.substring(7,token.length());

            System.out.println(token);
            System.out.println(jwtToken);

            String username = jwtService.getUsername(jwtToken);
            System.out.println(username);

        }

filterChain.doFilter(request,response);

    }
}
