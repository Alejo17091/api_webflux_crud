package com.example.crud_webflux_api.userconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// Define los usuarios y sus roles en memoria para pruebas o desarrollo
@Configuration
public class UserConfig {
    
// Define los usuarios y sus roles en memoria para pruebas o desarrollo
    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        // Crea un codificador de contraseñas (Spring exige que las contraseñas estén encriptadas)
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // Define un usuario con rol ADMIN
        UserDetails user = User
                .withUsername("admin")                    // nombre de usuario
                .password(encoder.encode("admin123"))     // contraseña codificada
                .roles("ADMIN")                           // rol asignado
                .build();

        // Retorna el servicio de usuarios en memoria con el usuario creado
        return new MapReactiveUserDetailsService(user);
    }


}
