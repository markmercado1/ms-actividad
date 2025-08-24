package com.example.ms_empleo.service;
import com.example.ms_empleo.models.Empleo;

import java.util.List;
import java.util.Optional;

public interface IEmpleoService {
    Empleo save(Empleo empleo);
    Empleo update(Long id, Empleo empleo);
    void delete(Long id);
    Optional<Empleo> findById(Long id);
    List<Empleo> findAll();
}