package com.backend.springboot.app.beneficiarios.controllers;


import com.backend.springboot.app.beneficiarios.models.service.IRegistroService;
import com.backend.springboot.app.commons.beneficiarios.models.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RegistroController {

    @Autowired
    private IRegistroService registroService;

    @GetMapping("/registro/listar")
    public ResponseEntity<?> listar() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", registroService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/registro/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Registro data = registroService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
