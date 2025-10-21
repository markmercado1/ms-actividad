package com.example.ms_persona.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaCreadaEvent {
    private Long idPersona;
    private String nombre;
    private String dni;
}