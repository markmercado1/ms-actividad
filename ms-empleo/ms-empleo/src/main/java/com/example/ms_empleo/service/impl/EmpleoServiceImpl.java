package com.example.ms_empleo.service.impl;

import com.example.ms_empleo.dto.EmpleoDto;
import com.example.ms_empleo.dto.EmpleoRequest;
import com.example.ms_empleo.dto.PaisDto;
import com.example.ms_empleo.dto.PersonaDto;
import com.example.ms_empleo.feign.PaisFeign;
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
    private final PaisFeign paisFeign;

    @Override
    public EmpleoDto save(EmpleoRequest request) {
        // Validar si existe la persona en el otro microservicio
        PersonaDto persona = personaFeign.buscarPorId(request.getIdPersona()).getBody();
        if (persona == null) {
            throw new RuntimeException("La persona con id " + request.getIdPersona() + " no existe");
        }
        PaisDto pais = paisFeign.buscarPorId(request.getIdPais()).getBody();
        if (pais == null) {
            throw new RuntimeException("El pais con id " + request.getIdPais() + " no existe");
        }

        // Crear el empleo
        Empleo empleo = new Empleo();
        empleo.setPuesto(request.getPuesto());
        empleo.setSalario(request.getSalario());
        empleo.setEmpresa(request.getEmpresa());
        empleo.setIdPersona(request.getIdPersona());
        empleo.setIdPais(request.getIdPais());
        empleoRepository.save(empleo);

        // Armar respuesta
        EmpleoDto empleoDto = new EmpleoDto();
        empleoDto.setIdEmpleo(empleo.getIdEmpleo());
        empleoDto.setPuesto(empleo.getPuesto());
        empleoDto.setSalario(empleo.getSalario());
        empleoDto.setEmpresa(empleo.getEmpresa());
        empleoDto.setIdPersona(empleo.getIdPersona());
        empleoDto.setPersona(persona);
        empleoDto.setIdPais(empleo.getIdPais());
        empleoDto.setPais(pais);// se incluye todo el body del otro microservicio
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
        PaisDto paisDto= paisFeign.buscarPorId(empleo.getIdPais()).getBody();
        EmpleoDto empleoDto = new EmpleoDto();
        empleoDto.setIdEmpleo(empleo.getIdEmpleo());
        empleoDto.setEmpresa(empleo.getEmpresa());
        empleoDto.setSalario(empleo.getSalario());
        empleoDto.setPuesto(empleo.getPuesto());
        empleoDto.setPersona(personaDto);
        empleoDto.setPais(paisDto);
        return empleoDto;
    }
    @Override
    public List<Empleo> findAll() {
        return empleoRepository.findAll();
    }
    @Override
    public void crearPerfilVacio(Long personaId, String nombre, String apellido) {
        // Aquí podrías guardar un registro de empleo con datos vacíos iniciales
        System.out.println("🧩 Creando perfil de empleo vacío para persona: " + nombre + " " + apellido);
    }
}