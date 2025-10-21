package com.example.ms_empleo.repository;

import com.example.ms_empleo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
