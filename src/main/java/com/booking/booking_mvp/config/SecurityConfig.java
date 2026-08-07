package com.booking.booking_mvp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {


        http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/booking",
                                "/api/bookings",
                                "/thank-you",
                                "/css/**",
                                "/js/**"
                        )
                        .permitAll()

                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .permitAll()

                )


                .formLogin(login -> login

                        .defaultSuccessUrl(
                                "/admin",
                                true
                        )

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