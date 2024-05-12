package br.com.celsonfernando.gestao_vagas.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.celsonfernando.gestao_vagas.modules.providers.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProvider jwtProvider;


    @Override
    protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request,
    @SuppressWarnings("null") HttpServletResponse response,
    @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {
                SecurityContextHolder.getContext().setAuthentication(null);
                String header = request.getHeader("Authorization");

            if (header != null) {
                var subjectToken = this.jwtProvider.validateToken(header);

                if(subjectToken.isEmpty()) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                request.setAttribute("company_id", subjectToken);
                UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(
                    subjectToken,
                    null,
                    Collections.emptyList()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            

        filterChain.doFilter(request, response);
    }
}
