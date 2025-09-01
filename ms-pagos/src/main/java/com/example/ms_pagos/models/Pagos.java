package com.example.ms_pagos.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagos {

    @Id
    @GeneratedValue
    private String id;
    private String descripcion;
    private LocalDate fecha;
    private BigDecimal monto;
}
