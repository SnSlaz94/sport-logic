package com.sportlogic.sport_logic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Permite usar @PreAuthorize en Controllers para mayor precisión
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Recursos públicos
                .requestMatchers("/login", "/css/**", "/js/**", "/images/**").permitAll()
                
                // Rutas base comunes
                .requestMatchers("/inicio", "/mi-perfil").authenticated()

                // --- MÓDULO PERSONAS Y USUARIOS ---
                // Solo ADMIN y DIRECTIVO gestionan la estructura (Crear/Editar/Borrar)
                .requestMatchers("/personas/**", "/usuarios/**").hasAnyRole("ADMIN", "DIRECTIVO")

                // --- MÓDULO ENTRENAMIENTOS ---
                // 1. Gestión (Solo los que pueden modificar)
                .requestMatchers(
                    "/horarios/nuevo", "/horarios/editar/**", "/horarios/guardar", "/horarios/eliminar/**",
                    "/sesiones/nuevo", "/sesiones/editar/**", "/sesiones/guardar", "/sesiones/eliminar/**")
                    .hasAnyRole("ADMIN", "DIRECTIVO", "ENTRENADOR")

                // 2. Consulta (Todos, incluido DEPORTISTA)
                .requestMatchers("/entrenamientos").hasAnyRole("ADMIN", "DIRECTIVO", "ENTRENADOR", "MEDICO")
                // 2. Las listas de horarios y sesiones SÍ son para deportistas
                .requestMatchers("/horarios", "/sesiones").hasAnyRole("ADMIN", "DIRECTIVO", "ENTRENADOR", "MEDICO", "DEPORTISTA")
                                // --- GESTIÓN MÉDICA Y FICHAS ---
                // Solo ADMIN, DIRECTIVO y MÉDICO pueden crear o editar fichas
                .requestMatchers("/fichas/nuevo", "/fichas/editar/**", "/fichas/eliminar/**")
                    .hasAnyRole("ADMIN", "DIRECTIVO", "MEDICO")
                // Médicos, Directivos y ADMIN pueden gestionar médicos; otros solo consultar si es necesario
                .requestMatchers("/medicos/**")
                    .hasAnyRole("ADMIN", "DIRECTIVO")
                // Consulta de fichas (Incluso Entrenadores y Deportistas según tu matriz)
                .requestMatchers("/fichas", "/fichas/ver/**")
                    .hasAnyRole("ADMIN", "DIRECTIVO", "MEDICO", "ENTRENADOR", "DEPORTISTA")

                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/inicio", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
}