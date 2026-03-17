package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {
}