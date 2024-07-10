package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT username, password, TRUE as enabled FROM users WHERE username = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM users WHERE username = ?");
        return userDetailsManager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .requestMatchers("/user").permitAll()
                                .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin
                                
                                .defaultSuccessUrl("/comptes/2", true)
                                .failureUrl("/login?error=true")
                                .usernameParameter("username")
                                .passwordParameter("password")
                );
        return http.build();
    }
}

