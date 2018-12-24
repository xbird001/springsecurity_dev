package com.xbird.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationFailureHandler xbirdAuthenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler xbirdAuthenticationSuccessfulHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(xbirdAuthenticationSuccessfulHandler)
                .failureHandler(xbirdAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/signIn.html","/authentication/require","/authentication/form").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
