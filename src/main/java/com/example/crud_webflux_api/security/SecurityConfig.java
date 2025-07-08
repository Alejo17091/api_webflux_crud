package com.example.crud_webflux_api.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
// Habilita anotaciones como @PreAuthorize para controlar acceso por roles o condiciones
@EnableReactiveMethodSecurity
public class SecurityConfig {
    // Define el filtro de seguridad para todas las peticiones HTTP
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                // Desactiva CSRF (Cross Site Request Forgery) ya que no es necesario para APIs sin sesión
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                
                // Define las reglas de autorización para las rutas
                .authorizeExchange(exchange -> exchange
                        // Permite acceso libre sin autenticación a cualquier ruta que empiece con /api/public/
                        .pathMatchers("/api/public/**").permitAll()

                        // Cualquier otra ruta requiere autenticación
                        .anyExchange().authenticated()
                )

                // Habilita autenticación básica (usuario y contraseña)
                .httpBasic() // También puedes usar JWT o OAuth si lo prefieres luego
                .and()

                // Desactiva el formulario de login (no es útil para APIs REST)
                .formLogin().disable()

                // Construye y retorna el filtro de seguridad
                .build();
    }
}

