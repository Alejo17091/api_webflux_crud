package com.example.crud_webflux_api.service;

import com.example.crud_webflux_api.model.contacto;
import com.example.crud_webflux_api.repository.ContactoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactoService {

    private final ContactoRepository repo;

    public ContactoService(ContactoRepository repo) {
        this.repo = repo;
    }

    public Flux<contacto> listartodos() {
        return repo.findAll();
    }

    public Mono<contacto> buscarid(String id) {
        return repo.findById(id);
    }

    public Flux<contacto> buscarpornombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    public Mono<contacto> guardar(contacto c) {
        return repo.save(c);
    }

    public Mono<Void> eliminar(String id) {
        return repo.deleteById(id);
    }

    // Comentarios:
    // - Métodos reactivamente devuelven Mono/Flux
    // - La lógica se delega al repositorio

}
