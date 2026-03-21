package com.college.project.PlacementAutomationandStudentRequirementSystem.config;

import com.college.project.PlacementAutomationandStudentRequirementSystem.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    // [ Http rules, filter chain ]

    private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                // Disable CSRF for REST APIs
                .csrf(AbstractHttpConfigurer::disable)
                // Stateless session management
                .sessionManagement(sesssion ->
                        sesssion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())
                // Configure endpoint authorization
                .authorizeHttpRequests(auth->auth
                        // Public auth endpoints (login, register)
                        .requestMatchers("/auth/**").permitAll()
                        // Protected student endpoints
                        .requestMatchers("/student/**").authenticated()
                                .anyRequest().authenticated()
                )
                // add jwt filter before UsernamePasswordAuthenticationFilter so that jwt token is checked before user authentication
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}
