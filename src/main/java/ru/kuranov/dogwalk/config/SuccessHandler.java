package ru.kuranov.dogwalk.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String redirectedPage = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(authority -> {
                    if (authority.equals("WALKER")) {
                        return "/profile/walker";
                    } else if (authority.equals("OWNER")) {
                        return "/profile/owner";
                    }
                    return "/";
                })
                .findFirst()
                .get();
        response.sendRedirect(redirectedPage);
    }
}
