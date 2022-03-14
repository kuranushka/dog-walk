package ru.kuranov.dogwalk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import ru.kuranov.dogwalk.model.service.implement.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> {
            requests.antMatchers("/**").permitAll();
            requests.antMatchers("/user-login").permitAll();
            requests.antMatchers("/profile/owner/**").hasRole("OWNER");
            requests.antMatchers("/profile/walker/**").hasRole("WALKER");
        });
        http.authorizeRequests((requests) -> ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.anyRequest()).authenticated());
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user-login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        // run custom logics upon successful login
                        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                        String redirectedPage = userDetails.getAuthorities()
                                .stream()
                                        .map(GrantedAuthority::getAuthority)
                                .map(authority -> {
                                    if (authority.equals("WALKER")) {
                                        return "/profile/walker";
                                    } else if (authority.equals("OWNER")) {
                                        return "/profile/owner";
                                    } return "/";
                                })
                                .findFirst()
                                .get();
                        response.sendRedirect(redirectedPage);

                        super.onAuthenticationSuccess(request, response, authentication);
                    }
                });


//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                        redirectPage = authentication.getAuthorities()
//                                .stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .map(authority -> {
//                                    if (authority.equals("WALKER")) {
//                                        return redirectPage = "/profile/walker";
//                                    } else if (authority.equals("OWNER")) {
//                                        return redirectPage = "/profile/owner";
//                                    } return "/";
//                                })
//                                .findFirst()
//                                .get();
//                    }
//                })
//                .defaultSuccessUrl(redirectPage);

        http
                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
        http.httpBasic();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return authenticationProvider;
    }
}
