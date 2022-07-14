package com.backend.springboot.app.beneficiarios.models.service;

import com.backend.springboot.app.beneficiarios.models.repository.RegistroRepository;
import com.backend.springboot.app.commons.beneficiarios.models.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistroServiceImpl implements IRegistroService{

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> findAll() {
        return (List<Registro>) registroRepository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Registro findById(Long id) {
        return registroRepository.findById( id ).orElse(null);
    }
}
