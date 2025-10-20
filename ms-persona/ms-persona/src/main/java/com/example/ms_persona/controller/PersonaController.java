package com.example.ms_persona.controller;

import com.example.ms_persona.dtos.PersonaDTO;
import com.example.ms_persona.events.PersonaCreadaEvent;
import com.example.ms_persona.models.Persona;
import com.example.ms_persona.service.KafkaProducerService;
import com.example.ms_persona.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;
    private final KafkaProducerService kafkaProducerService;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){

        return ResponseEntity.ok().body(personaService.listar());
    }

    @PutMapping()
    public ResponseEntity<Persona> listById(@PathVariable (required = true) Long id){
        return ResponseEntity.ok().body(personaService.listarPorId(id).get());


    }
    @PostMapping
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO dto) {
        PersonaDTO personaGuardada = personaService.guardar(dto);

        // Enviar evento a Kafka con los datos persistidos
        PersonaCreadaEvent event = new PersonaCreadaEvent(
                personaGuardada.getIdPersona(),
                personaGuardada.getNombre(),
                personaGuardada.getDni());
        kafkaProducerService.enviarPersonaCreada(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardada);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarPorId(@PathVariable Long id) {
        Persona persona = personaService.buscarPorId(id);
        return ResponseEntity.ok(persona);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        personaService.eliminarPorId(id);
        return "Se elimino Correctamente";
    }

}
