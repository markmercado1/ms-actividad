package com.example.ms_empleo.dto;

import lombok.Data;

@Data
public class EmpleoRequest {
    private String puesto;
    private Double salario;
    private String empresa;
    private Long idPersona;
    private Long idPais;// aquí llega la referencia
}