package com.example.crud_webflux_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud_webflux_api.model.contacto;
import com.example.crud_webflux_api.service.ContactoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final ContactoService servicio;

    public ContactoController(ContactoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public Flux<contacto> Listar() {
        return servicio.listartodos();
    }

    @GetMapping("/{id}")
    public Mono<contacto> porid(@PathVariable String id) {
        return servicio.buscarid(id);
    }

    @PostMapping
    public Mono<contacto> crearcontacto(@RequestBody contacto c) {
        return servicio.guardar(c);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarid(@PathVariable String id) {
        return servicio.eliminar(id);

    }
    // Comentarios:
    // - @RestController y @RequestMapping definen un API REST
    // - @Valid valida los datos del body en POST
    // - @GetMapping y @PostMapping manejan solicitudes HTTP
}
