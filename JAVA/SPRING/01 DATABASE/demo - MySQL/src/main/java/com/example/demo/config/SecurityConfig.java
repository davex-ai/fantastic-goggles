package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails ryzen = User.builder().username("ryzen").password("{noop}edcvh").roles("EMPLOYEE").build();
        UserDetails goku = User.builder().username("goku").password("{noop}edcvh").roles("EMPLOYEE", "MANAGER").build();
        UserDetails adam = User.builder().username("adam").password("{noop}edcvh").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        return new InMemoryUserDetailsManager(ryzen, goku, adam);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/customers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customers/**").hasRole("ADMIN"));

        // using basic auth
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}