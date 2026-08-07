package com.booking.booking_mvp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(
                                "/api/bookings"
                        )
                )

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/booking",
                                "/rooms",
                                "/thank-you",
                                "/login",
                                "/css/**",
                                "/js/**"
                        )
                        .permitAll()


                        .requestMatchers(
                                "/api/bookings"
                        )
                        .permitAll()


                        .requestMatchers(
                                "/admin/**"
                        )
                        .hasRole("ADMIN")


                        .anyRequest()
                        .authenticated()

                )


                .formLogin(login -> login

                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl(
                                "/admin",
                                true
                        )
                        .permitAll()
                )
                .logout(logout -> logout

                        .logoutSuccessUrl("/")
                );


        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager users(
            PasswordEncoder encoder
    ){
        System.out.println("=== ADMIN CREATED ===");
        UserDetails admin =
                User.builder()
                        .username("admin")
                        .password(
                                encoder.encode("admin123")
                        )
                        .roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(admin);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}