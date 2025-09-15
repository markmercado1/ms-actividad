package com.example.ms_empleo.feign;


import com.example.ms_empleo.dto.PersonaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-persona", path = "/personas")
public interface PersonaFeign {

    @GetMapping("/{id}")
    ResponseEntity<PersonaDto> buscarPorId(@PathVariable Long id);


    @PostMapping()
    ResponseEntity <PersonaDto> save(@RequestBody PersonaDto persona);






}
