package org.example.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import  org.example.repository.LibroRepository;
import  org.example.model.Libro;
import  org.example.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }
}