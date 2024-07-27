// package com.backend_xeercise.taskmanagementsystem.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @SuppressWarnings("deprecation")
// @Bean
// SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// http
// // CSRF configuration
// .csrf(csrf -> csrf
// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
// // Authorization configuration
// .authorizeRequests(authorizeRequests -> authorizeRequests
// .requestMatchers("/", "/login", "/access-denied", "/logout-success")
// .permitAll()
// .requestMatchers("/api/**").hasRole("USER")
// .requestMatchers("/wep/**").hasRole("ADMIN")
// .anyRequest().authenticated())
// // Form login configuration
// .formLogin(formLogin -> formLogin
// .loginPage("/login")
// .permitAll())
// // Logout configuration
// .logout(logout -> logout
// .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
// .logoutSuccessUrl("/login?logout")
// .invalidateHttpSession(true)
// .deleteCookies("JSESSIONID"))
// // Exception handling configuration
// .exceptionHandling(exceptionHandling -> exceptionHandling
// .accessDeniedHandler((request, response, accessDeniedException) -> {
// // Log details about the denied access
// accessDeniedException.printStackTrace();
// response.sendRedirect("/access-denied");
// }));

// return http.build();
// }

// }
