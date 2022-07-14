package com.backend.springboot.app.beneficiarios.models.service;


import com.backend.springboot.app.commons.beneficiarios.models.entity.Registro;

import java.util.List;

public interface IRegistroService {

    public List<Registro> findAll();
    public Registro findById(Long id);
}
