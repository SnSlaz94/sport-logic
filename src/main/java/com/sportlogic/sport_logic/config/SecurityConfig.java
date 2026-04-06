package com.sportlogic.sport_logic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

http
.authorizeHttpRequests(auth -> auth

.requestMatchers("/login", "/css/**", "/js/**").permitAll()

.requestMatchers("/inicio").authenticated()
.requestMatchers("/mi-perfil").authenticated()

.requestMatchers("/personas/**")
.hasAnyRole("ADMIN","DIRECTIVO")

.requestMatchers("/jugadores/**")
.hasAnyRole("ADMIN","DIRECTIVO")

.requestMatchers("/usuarios/**")
.hasAnyRole("ADMIN","DIRECTIVO")

.requestMatchers("/entrenamientos/**")
.hasAnyRole("ADMIN","DIRECTIVO","ENTRENADOR")

.requestMatchers("/medicos/**")
.hasAnyRole("ADMIN","DIRECTIVO")

.requestMatchers("/fichas/**")
.hasAnyRole("ADMIN","DIRECTIVO","MEDICO")

.anyRequest().authenticated()
)

.formLogin(form -> form
.loginPage("/login")
.defaultSuccessUrl("/inicio", true)
.permitAll()
)

.logout(logout -> logout
.logoutSuccessUrl("/login")
.permitAll()
);

return http.build();

}

}