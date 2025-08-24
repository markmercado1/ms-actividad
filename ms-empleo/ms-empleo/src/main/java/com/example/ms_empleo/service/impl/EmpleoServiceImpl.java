package com.example.ms_empleo.service.impl;

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

    @Override
    public Empleo save(Empleo empleo) {
        return empleoRepository.save(empleo);
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
    public Optional<Empleo> findById(Long id) {
        return empleoRepository.findById(id);
    }

    @Override
    public List<Empleo> findAll() {
        return empleoRepository.findAll();
    }
}