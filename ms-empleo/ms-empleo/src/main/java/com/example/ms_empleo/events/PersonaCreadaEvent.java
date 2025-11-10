package com.example.ms_empleo.events;

import lombok.Data;

@Data
public class PersonaCreadaEvent {
    private Long idPersona;
    private String nombre;
    private String dni;

}