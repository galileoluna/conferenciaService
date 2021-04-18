package com.galileo.conferenciaservice.repository;

import com.galileo.conferenciaservice.model.Conferencia;

import java.util.List;
import java.util.Optional;

public interface ConferenciaRepository {

    Optional<Conferencia> findById(Integer id);
    List<Conferencia> findAll();
    boolean update(Conferencia conferencia);
    Conferencia save(Conferencia conferencia);
    boolean delete(Integer id);
}
