package com.example.ms_empleo.service;
import com.example.ms_empleo.dto.EmpleoDto;
import com.example.ms_empleo.dto.EmpleoRequest;
import com.example.ms_empleo.models.Empleo;

import java.util.List;



public interface IEmpleoService {
    EmpleoDto save(EmpleoRequest empleo);
    Empleo update(Long id, Empleo empleo);
    void delete(Long id);
    EmpleoDto findById(Long id);
    List<Empleo> findAll();
    void crearPerfilVacio(Long personaId, String nombre, String dni);
}