package com.example.ms_empleo.service;

import com.example.ms_empleo.models.Empresa;

import java.util.List;

public interface EmpresaService {

    Empresa findById(Long id);
    Empresa guardar(Empresa empresa);
    Empresa actualizar(Long id,Empresa empresa);
    void delete(Long id);
    List<Empresa> findAll();


}
