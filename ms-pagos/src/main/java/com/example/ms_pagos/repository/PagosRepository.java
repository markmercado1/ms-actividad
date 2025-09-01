package com.example.ms_pagos.repository;

import com.example.ms_pagos.models.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosRepository extends JpaRepository<Pagos, Long> {
}
