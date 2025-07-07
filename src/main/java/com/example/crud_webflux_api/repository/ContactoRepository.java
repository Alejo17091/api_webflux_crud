package com.example.crud_webflux_api.repository;

import com.example.crud_webflux_api.model.contacto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

//consulta,retorno
public interface ContactoRepository extends ReactiveMongoRepository<contacto, String> {
    Flux<contacto> findByNombreContainingIgnoreCase(String nombre);
    // nos va ayudar en realizar las consultas

    // ejemplo:
    // Si hay "Ana", "Anastasio" y "banana" en la base:
    // repo.findByNombreContainingIgnoreCase("ana")
    // → devuelve ["Ana", "Anastasio", "banana"] como Flux<Contacto>

}
