package com.example.sebastian.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sebastian.model.Evento;
import com.example.sebastian.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento guardar(Evento evento) {
        evento.setId(UUID.randomUUID().toString());
        return eventoRepository.save(evento);
    }

    public void eliminarPorId(String id) {
        eventoRepository.eliminarPorId(id);
    }

    public Evento buscarEvento(String id) {
        return eventoRepository.buscarPorId(id);
    }

    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepository.buscarPorNombre(nombre);
    }

    public Evento actulizarEvento(String id, Evento nuevoEvento) {
        return eventoRepository.actualizar(id, nuevoEvento);
    }
    
    public List<Evento> findALL() {
        return eventoRepository.findALL();
    }

    public List<Evento> ordenarEventos() {
        return eventoRepository.ordenarEventos();
    }


    
}
