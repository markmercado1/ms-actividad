package com.example.ms_empleo.controller;

import com.example.ms_empleo.dto.EmpleoDto;
import com.example.ms_empleo.dto.EmpleoRequest;
import com.example.ms_empleo.models.Empleo;
import com.example.ms_empleo.service.IEmpleoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/empleos")
@RequiredArgsConstructor
public class EmpleoController {

    private final IEmpleoService empleoService;

    @PostMapping
    public ResponseEntity<EmpleoDto> create(@RequestBody EmpleoRequest empleo) {
        return ResponseEntity.ok(empleoService.save(empleo));
    }

    @GetMapping
    public ResponseEntity<List<Empleo>> getAll() {
        return ResponseEntity.ok(empleoService.findAll());
    }

    @GetMapping("/{id}")
    public EmpleoDto getById(@PathVariable Long id) {
        return empleoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleo> update(@PathVariable Long id, @RequestBody Empleo empleo) {
        return ResponseEntity.ok(empleoService.update(id, empleo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empleoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}