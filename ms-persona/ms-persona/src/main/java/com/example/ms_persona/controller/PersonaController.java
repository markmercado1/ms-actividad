package com.example.ms_persona.controller;

import com.example.ms_persona.models.Persona;
import com.example.ms_persona.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        return ResponseEntity.ok().body(personaService.listar());
    }

    @PostMapping()
    public ResponseEntity <Persona> save(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.guardar(persona));

    }
    @PutMapping()
    public ResponseEntity<Persona> listById(@PathVariable (required = true) Long id){
        return ResponseEntity.ok().body(personaService.listarPorId(id).get());


    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        personaService.eliminarPorId(id);
        return "Se elimino Correctamente";
    }

}
