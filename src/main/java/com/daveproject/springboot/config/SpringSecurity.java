package com.daveproject.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register/**").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/user").hasRole("ADMIN")
                .and()
                .formLogin(
                        form ->  form.loginPage("/login").loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users").permitAll()

                ).logout(
                        logout -> logout.
                                logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
                                permitAll()
                );
        return http.build();
    }
}