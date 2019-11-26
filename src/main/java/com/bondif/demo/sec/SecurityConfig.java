package com.bondif.demo.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/clients/**").hasAnyAuthority("USER", "ANALYSE_MANAGER", "ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/analyses/**").hasAnyAuthority("USER", "ANALYSE_MANAGER", "ADMIN");

        http.authorizeRequests().antMatchers("/clients/**").hasAnyAuthority("ANALYSE_MANAGER", "ADMIN");
        http.authorizeRequests().antMatchers("/analyses/**").hasAnyAuthority("ANALYSE_MANAGER", "ADMIN");

        http.authorizeRequests().anyRequest().authenticated();

        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
