package com.example.ms_empleo.dto;
import lombok.Data;
@Data
public class EmpleoDto {


    private Long idEmpleo;
    private String puesto;
    private Double salario;
    private String empresa;
    private Long idPersona;
    private PersonaDto persona;



}
