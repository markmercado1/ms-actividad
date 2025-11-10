package com.example.ms_empleo.controller;

import com.example.ms_empleo.dto.EmpresaDto;
import com.example.ms_empleo.models.Empresa;
import com.example.ms_empleo.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.guardar(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.actualizar(id, empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
