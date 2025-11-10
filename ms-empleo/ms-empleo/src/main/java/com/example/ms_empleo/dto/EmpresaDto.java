package com.example.ms_empleo.dto;

import lombok.Data;

@Data
public class EmpresaDto {

    private Long idEmpresa;
    private String nombre;
    private Long idEmpleo;
    private EmpleoDto empleo;
    private Long idPersona;
    private PersonaDto persona;



}
