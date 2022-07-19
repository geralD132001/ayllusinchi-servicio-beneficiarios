package com.backend.springboot.app.beneficiarios.controllers;

import com.backend.springboot.app.beneficiarios.models.service.IPersonaSerivice;
import com.backend.springboot.app.commons.beneficiarios.models.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = { "https://ayllusinchi-app.azurewebsites.net" })
@RestController
public class PersonaController {

    @Autowired
    private IPersonaSerivice personaSerivice;

    @GetMapping("/persona/listar")
    public ResponseEntity<?> listar() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", personaSerivice.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaSerivice.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Persona con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
