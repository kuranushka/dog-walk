package ru.kuranov.dogwalk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kuranov.dogwalk.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final SuccessHandler successHandler;

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

        http.authorizeRequests((requests) -> ((ExpressionUrlAuthorizationConfigurer
                .AuthorizedUrl) requests.anyRequest())
                .authenticated());

        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user-login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(successHandler);

        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
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
