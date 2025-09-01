package com.example.ms_pagos.service.imp;

import com.example.ms_pagos.models.Pagos;
import com.example.ms_pagos.repository.PagosRepository;
import com.example.ms_pagos.service.PagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagosServiceImp implements PagosService {
    private final PagosRepository pagosRepository;

    @Override
    public List<Pagos> listar() {
        return pagosRepository.findAll();
    }

    @Override
    public Pagos findById(Long id) {
        return pagosRepository.findById(id).get();
    }

    @Override
    public Pagos create(Pagos pagos) {
        return pagosRepository.save(pagos);
    }

    @Override
    public Pagos update(Pagos pagos) {
        return pagosRepository.save(pagos);
    }

    @Override
    public void delete(Pagos pagos) {
        pagosRepository.delete(pagos);

    }
}
