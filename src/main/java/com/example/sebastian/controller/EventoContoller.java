package com.example.sebastian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sebastian.model.Evento;
import com.example.sebastian.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/eventos")
public class EventoContoller {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> findALL() {
        return eventoService.findALL();
    }

    @GetMapping("/{id}")
    public Evento buscarEvento(@PathVariable String id) {
        return eventoService.buscarEvento(id);
    }

    @GetMapping("nombre/{nombre}")
    public List<Evento> buscarPorEventos(@PathVariable String nombre) {
        return eventoService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Evento crearEvento(@Valid @RequestBody Evento evento) {
        return eventoService.guardar(evento);
    
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable String id) {
        eventoService.eliminarPorId(id);
    }

    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable String id, @Valid @RequestBody Evento eventoActualizado) {
        return eventoService.actulizarEvento(id, eventoActualizado);
    }

    @GetMapping("/ordena/{ordenar}")
    public List<Evento> ordenrarEventos() {
        return eventoService.ordenarEventos();
    }
    


    
}
