package com.cmm.mspais.controller;

import com.cmm.mspais.models.Pais;
import com.cmm.mspais.service.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;


    @GetMapping
    public ResponseEntity<List<Pais>> listar(){

        return ResponseEntity.ok().body(paisService.listar());
    }

    @PostMapping()
    public ResponseEntity <Pais> save(@RequestBody Pais pais){
        return ResponseEntity.ok(paisService.guardar(pais));

    }


    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        paisService.delete(id);
        return "Se elimino Correctamente";
    }
}
