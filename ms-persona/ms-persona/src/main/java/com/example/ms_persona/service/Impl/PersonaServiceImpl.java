package com.example.ms_persona.service.Impl;

import com.example.ms_persona.models.Persona;
import com.example.ms_persona.repository.PersonaRepository;
import com.example.ms_persona.service.PersonaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository repository;
    @Override
    public List<Persona> listar() {
        return repository.findAll();
    }
    @Override
    public Persona buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con id: " + id));
    }
    @Override
    public Persona guardar(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public Optional<Persona> listarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);

    }
}
