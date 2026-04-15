package com.example.sebastian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sebastian.model.Evento;
import com.example.sebastian.service.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoContoller {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> findALL() {
        return ResponseEntity.ok(eventoService.findALL());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEvento(@PathVariable String id) {
        Evento evento = eventoService.buscarEvento(id);
        if (evento == null) return ResponseEntity.notFound().build(); // 404
        return ResponseEntity.ok(evento);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Evento>> buscarPorNombre(@PathVariable String nombre) {
        List<Evento> resultado = eventoService.buscarPorNombre(nombre);
        if (resultado.isEmpty()) return ResponseEntity.notFound().build(); // 404
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@Valid @RequestBody Evento evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.guardar(evento)); // 201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable String id) {
        Evento evento = eventoService.buscarEvento(id);
        if (evento == null) return ResponseEntity.notFound().build(); // 404
        eventoService.eliminarPorId(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable String id, @Valid @RequestBody Evento eventoActualizado) {
        Evento resultado = eventoService.actulizarEvento(id, eventoActualizado);
        if (resultado == null) return ResponseEntity.notFound().build(); // 404
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/ordenar")
    public ResponseEntity<List<Evento>> ordenarEventos() {
        return ResponseEntity.ok(eventoService.ordenarEventos()); // fix: ruta limpia sin param muerto
    }
}