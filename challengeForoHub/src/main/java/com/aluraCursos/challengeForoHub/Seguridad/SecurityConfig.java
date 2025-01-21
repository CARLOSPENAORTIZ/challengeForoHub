package com.aluraCursos.challengeForoHub.Seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  { // Configura los puntos finales y la seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers("/topicos/**").authenticated()  // Solo autenticados pueden acceder a los tópicos
//                .anyRequest().permitAll()  // El resto de las rutas pueden ser públicas
//                .and()
//                .formLogin()  // Autenticación básica
//                .and()
//                .csrf().disable();  // Desactiva la protección CSRF (solo si es necesario para pruebas)

        return http.build();
    }

    // Definir un usuario en memoria para pruebas
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("USER")
                .build());
        return manager;
    }

    // Codificación de la contraseña
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
