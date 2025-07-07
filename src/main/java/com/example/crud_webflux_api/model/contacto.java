package com.example.crud_webflux_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

@Data // data genera getters y setters, tostring, equals y hashcode
@NoArgsConstructor // genera constructor vacio
@AllArgsConstructor // genera cosntructor vacio
@Document(collection = "contactos") // spring data - indica que esta clase representa una coleccion de mongo db
public class contacto {

    @Id
    private String id;// identificador generado por mongo db

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @Pattern(regexp = "\\d{9}", message = "el telefono debe tener 9 digitos")
    private String telefono;

    @Email(message = "corrego invalido")
    private String correo;

    // Comentarios:
    // - @Document: indica colección Mongo
    // - @Id: campo clave primaria
    // - @NotBlank, @Pattern, @Email: validaciones reactivas

}
