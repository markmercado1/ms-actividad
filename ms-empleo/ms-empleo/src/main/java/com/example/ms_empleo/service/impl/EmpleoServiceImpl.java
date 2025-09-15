package com.example.ms_empleo.service.impl;

import com.example.ms_empleo.dto.EmpleoDto;
import com.example.ms_empleo.dto.EmpleoRequest;
import com.example.ms_empleo.dto.PersonaDto;
import com.example.ms_empleo.feign.PersonaFeign;
import com.example.ms_empleo.models.Empleo;
import com.example.ms_empleo.repository.EmpleoRepository;
import com.example.ms_empleo.service.IEmpleoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleoServiceImpl implements IEmpleoService {

    private final EmpleoRepository empleoRepository;
    private final PersonaFeign personaFeign;

    @Override
    public EmpleoDto save(EmpleoRequest request) {
        // Validar si existe la persona en el otro microservicio
        PersonaDto persona = personaFeign.buscarPorId(request.getIdPersona()).getBody();
        if (persona == null) {
            throw new RuntimeException("La persona con id " + request.getIdPersona() + " no existe");
        }

        // Crear el empleo
        Empleo empleo = new Empleo();
        empleo.setPuesto(request.getPuesto());
        empleo.setSalario(request.getSalario());
        empleo.setEmpresa(request.getEmpresa());
        empleo.setIdPersona(request.getIdPersona());
        empleoRepository.save(empleo);

        // Armar respuesta
        EmpleoDto empleoDto = new EmpleoDto();
        empleoDto.setIdEmpleo(empleo.getIdEmpleo());
        empleoDto.setPuesto(empleo.getPuesto());
        empleoDto.setSalario(empleo.getSalario());
        empleoDto.setEmpresa(empleo.getEmpresa());
        empleoDto.setIdPersona(empleo.getIdPersona());
        empleoDto.setPersona(persona); // se incluye todo el body del otro microservicio
        return empleoDto;
    }


    @Override
    public Empleo update(Long id, Empleo empleo) {
        return empleoRepository.findById(id).map(existing -> {
            existing.setPuesto(empleo.getPuesto());
            existing.setSalario(empleo.getSalario());
            existing.setEmpresa(empleo.getEmpresa());
            return empleoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Empleo no encontrado con id " + id));
    }

    @Override
    public void delete(Long id) {
        empleoRepository.deleteById(id);
    }

    @Override
    public EmpleoDto findById(Long id) {
        Empleo empleo = empleoRepository.findById(id).get();
        PersonaDto personaDto = personaFeign.buscarPorId(empleo.getIdPersona()).getBody();
        EmpleoDto empleoDto = new EmpleoDto();
        empleoDto.setIdEmpleo(empleo.getIdEmpleo());
        empleoDto.setEmpresa(empleo.getEmpresa());
        empleoDto.setSalario(empleo.getSalario());
        empleoDto.setPuesto(empleo.getPuesto());
        empleoDto.setPersona(personaDto);
        return empleoDto;
    }
    @Override
    public List<Empleo> findAll() {
        return empleoRepository.findAll();
    }
}