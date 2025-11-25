package com.example.ms_persona.service;

import com.example.ms_persona.dtos.PersonaDTO;
import com.example.ms_persona.models.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listar();
    Persona buscarPorId(Long id);
    PersonaDTO guardar(PersonaDTO personaDTO);
    PersonaDTO actualizar(Long id, PersonaDTO personaDTO);
    Optional<Persona> listarPorId(Long id);
    void eliminarPorId(Long id);
}

