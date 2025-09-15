package com.example.ms_empleo.service.impl;

import com.example.ms_empleo.models.Empresa;
import com.example.ms_empleo.repository.EmpresaRepository;
import com.example.ms_empleo.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;
    @Override
    public Empresa findById(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa actualizar(Long id, Empresa empresa) {
        return empresaRepository.findById(id).map(existing -> {
            existing.setNombre(empresa.getNombre());
            return empresaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Empleo no encontrado con id " + id));
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);

    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }
}
