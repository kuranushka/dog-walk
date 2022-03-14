package ru.kuranov.dogwalk.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class RedirectSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
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
