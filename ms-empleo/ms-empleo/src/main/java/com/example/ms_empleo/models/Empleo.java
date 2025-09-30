package com.example.ms_empleo.models;

import com.example.ms_empleo.dto.PaisDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "empleo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleo;

    @Column(nullable = false, length = 100)
    private String puesto;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false, length = 100)
    private String empresa;
    private Long idPersona;
    private Long idPais;



}