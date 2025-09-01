package com.example.ms_pagos.controller;

import com.example.ms_pagos.models.Pagos;
import com.example.ms_pagos.repository.PagosRepository;
import com.example.ms_pagos.service.PagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PagosController {

    private final PagosRepository pagosRepository;
    private final PagosService pagosService;

    @GetMapping
    public ResponseEntity<List<Pagos>> listar(){
        return ResponseEntity.ok().body(pagosService.listar());
    }

    @PostMapping()
    public ResponseEntity<Pagos> save(@RequestBody Pagos pagos) {
        return ResponseEntity.ok(pagosService.create(pagos));
    }





}
