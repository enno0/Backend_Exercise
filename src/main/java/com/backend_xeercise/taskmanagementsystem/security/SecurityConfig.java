package com.backend_xeercise.taskmanagementsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @SuppressWarnings("deprecation")
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                                                .ignoringRequestMatchers("/apii/**")) // Disable CSRF for /api/login
                                .authorizeRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("/login", "/apii/**").permitAll()
                                                .requestMatchers("/web/tasks").hasRole("USER")
                                                .requestMatchers("/web/**", "/web/users", "/web/userRole", "/api/**")
                                                .hasRole("ADMIN")
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID")
                                                .addLogoutHandler(logoutHandler()))
                                .exceptionHandling(exceptionHandling -> exceptionHandling
                                                .accessDeniedHandler((request, response, accessDeniedException) -> {
                                                        accessDeniedException.printStackTrace();
                                                        response.sendRedirect("/access-denied");
                                                }))
                                .sessionManagement(sessionManagement -> sessionManagement
                                                .maximumSessions(1)
                                                .sessionRegistry(sessionRegistry())
                                                .expiredUrl("/login?expired"));

                return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public SessionRegistry sessionRegistry() {
                return new SessionRegistryImpl();
        }

        @Bean
        public HttpSessionEventPublisher httpSessionEventPublisher() {
                return new HttpSessionEventPublisher();
        }

        @Bean
        public LogoutHandler logoutHandler() {
                return new LogoutHandler() {
                        @Override
                        public void logout(HttpServletRequest request, HttpServletResponse response,
                                        org.springframework.security.core.Authentication authentication) {
                                if (authentication != null && authentication.getPrincipal() != null) {
                                        sessionRegistry().getAllSessions(authentication.getPrincipal(), false)
                                                        .forEach(sessionInformation -> sessionInformation.expireNow());
                                }
                        }
                };
        }
}
