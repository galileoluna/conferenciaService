package com.galileo.conferenciaservice.service;

import com.galileo.conferenciaservice.model.Conferencia;
import com.galileo.conferenciaservice.repository.ConferenciaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ConferenciaServiceImpl implements ConferenciaService{
    private final ConferenciaRepository conferenciaRepository;
    private static final Logger logger = LogManager.getLogger(ConferenciaServiceImpl.class);

    public ConferenciaServiceImpl(ConferenciaRepository conferenciaRepository) {
        this.conferenciaRepository = conferenciaRepository;
    }

    @Override
    public Optional<Conferencia> findById(Integer id) {
        logger.info("Find conferencia with id: {}", id);
        return conferenciaRepository.findById(id);
    }

    @Override
    public List<Conferencia> findAll() {
        logger.info("Find all products");
        return conferenciaRepository.findAll();
    }

    @Override
    public boolean update(Conferencia conferencia) {
        logger.info("Update conferencia: {}", conferencia);
        return conferenciaRepository.update(conferencia);
    }

    @Override
    public Conferencia save(Conferencia conferencia) {
        conferencia.setId_evento(1);

        logger.info("Save conferencia to the database: {}", conferencia);
        return conferenciaRepository.save(conferencia);
    }

    @Override
    public boolean delete(Integer id) {
        logger.info("Delete conferencia with id: {}", id);
        return conferenciaRepository.delete(id);
    }
}
