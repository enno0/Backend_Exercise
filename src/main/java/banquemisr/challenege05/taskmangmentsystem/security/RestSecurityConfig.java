package banquemisr.challenege05.taskmangmentsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class RestSecurityConfig {

    @SuppressWarnings("deprecation")
    @Bean
    SecurityFilterChain restSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**") // Apply this security config only to paths starting with /api/
                .csrf().disable() // Disable CSRF for REST API
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/auth/**").permitAll() // Allow access to /api/auth endpoint
                        .anyRequest().authenticated())
                .httpBasic(); // Use HTTP Basic authentication for REST API

        return http.build();
    }
}
