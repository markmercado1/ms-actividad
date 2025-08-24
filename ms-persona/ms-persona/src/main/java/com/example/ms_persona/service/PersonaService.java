package com.example.ms_persona.service;

import com.example.ms_persona.models.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> listar();

    Persona guardar(Persona persona);

    Persona actualizar(Persona persona);
    Optional<Persona>listarPorId(Long id);
    void eliminarPorId(Long id);
}
