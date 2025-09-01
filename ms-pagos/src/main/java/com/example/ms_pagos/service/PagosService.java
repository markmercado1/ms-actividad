package com.example.ms_pagos.service;

import com.example.ms_pagos.models.Pagos;

import java.util.List;
import java.util.Optional;

public interface PagosService {
    List<Pagos> listar();
    Pagos findById(Long id);
    Pagos create(Pagos pagos);
    Pagos update(Pagos pagos);
    void delete(Pagos pagos);
}
