package com.example.ms_persona.service.Impl;

import com.example.ms_persona.dtos.PersonaDTO;
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

    private PersonaDTO convertirADTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setIdPersona(persona.getIdPersona());
        dto.setNombre(persona.getNombre());
        dto.setDni(persona.getDni());
        return dto;
    }

    private Persona convertirAEntity(PersonaDTO dto) {
        Persona persona = new Persona();
        persona.setIdPersona(dto.getIdPersona());
        persona.setNombre(dto.getNombre());
        persona.setDni(dto.getDni());
        return persona;
    }

    @Override
    public PersonaDTO guardar(PersonaDTO personaDTO) {
        Persona persona = convertirAEntity(personaDTO);
        Persona personaGuardada = repository.save(persona);
        return convertirADTO(personaGuardada);
    }

    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO dto) {
        Persona personaExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con id: " + id));

        personaExistente.setNombre(dto.getNombre());
        personaExistente.setDni(dto.getDni());

        Persona personaActualizada = repository.save(personaExistente);
        return convertirADTO(personaActualizada);
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
