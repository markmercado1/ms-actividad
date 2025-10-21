package com.example.ms_empleo.feign;


import com.example.ms_empleo.dto.PersonaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-persona", path = "/personas")
public interface PersonaFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "personaListarPorIdCB", fallbackMethod = "fallBackPersona")

    ResponseEntity<PersonaDto> buscarPorId(@PathVariable Long id);
    default ResponseEntity<PersonaDto> fallBackPersona(Long id, Exception e) {
        PersonaDto personaDto = new PersonaDto();
        personaDto.setIdPersona(9000000L);
        personaDto.setNombre("Servicio Persona fallido");
        return ResponseEntity.ok(personaDto);
    }


    @PostMapping()
    ResponseEntity <PersonaDto> save(@RequestBody PersonaDto persona);






}
