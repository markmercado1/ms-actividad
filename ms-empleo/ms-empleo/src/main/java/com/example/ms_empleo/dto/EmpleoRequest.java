package com.example.ms_empleo.dto;

import lombok.Data;

@Data
public class EmpleoRequest {
    private String puesto;
    private Double salario;
    private String empresa;
    private Long idPersona; // aquí llega la referencia
}