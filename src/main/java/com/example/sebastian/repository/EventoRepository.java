package com.example.sebastian.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sebastian.model.Evento;

@Repository
public class EventoRepository {

    public List<Evento> eventos = new ArrayList<>();

        public Evento save(Evento evento) {
            eventos.add(evento);
            return evento;
    }

    public List<Evento> findALL() {
        return eventos;
    }

    public Evento buscarPorId(String id) {
        return eventos.stream().filter(evento -> evento.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminarPorId(String id) {
        eventos.removeIf(p -> p.getId().equals(id));
    }

    public List<Evento> buscarPorNombre(String nombre) {
        List<Evento> resultado = new ArrayList<>();
        for (Evento evento : eventos) {0
            if (evento.getNombre().equalsIgnoreCase(nombre)) {
            }
        }
        return resultado;
    }

    public Evento actualizar(String id, Evento nuevoEvento) {
        Evento existente = buscarPorId(id);
        if (existente != null) {
            existente.setEvento(nuevoEvento.getEvento());
            existente.setCapacidad(nuevoEvento.getCapacidad());
            existente.setNombre(nuevoEvento.getNombre());
            existente.setFecha(nuevoEvento.getFecha());
            existente.setUbicacion(nuevoEvento.getUbicacion());
            existente.setEstado(nuevoEvento.getEstado());
        }
        return existente;
    }

    public List<Evento> ordenarEventos() {
        return eventos.stream().sorted((a,b) -> Double.compare(a.getEvento(), b.getEvento())).toList();
    }











    
}
