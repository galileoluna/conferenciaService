package com.galileo.conferenciaservice.repository;

import com.galileo.conferenciaservice.model.Conferencia;
import com.galileo.conferenciaservice.service.ConferenciaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConferenciaRepositoyImpl implements ConferenciaRepository{

    private static final Logger logger = LogManager.getLogger(ConferenciaRepositoyImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;


    private final String queryfindById="SELECT * FROM conferencias WHERE id = ?";
    private final String queryfindall="SELECT * FROM conferencias";
    private final String queryUpdate="UPDATE conferencias SET nombre = ?, descripcion = ?, horadeinicio = ?,  horadefinalizacion = ? WHERE id = ?";

    public ConferenciaRepositoyImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;

        // Build a SimpleJdbcInsert object from the specified data source
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<Conferencia> findById(Integer id) {
        try {
            Conferencia conferencia = jdbcTemplate.queryForObject(queryfindById,
                    new Object[]{id},
                    (rs, rowNum) -> {
                        Conferencia conf = new Conferencia();
                        conf.setId_evento(rs.getInt("id_evento"));
                        conf.setNombre(rs.getString("nombre"));
                        conf.setDescripcion(rs.getString("descripcion"));
                        conf.setHoraDeInicio(rs.getString("horadeinicio"));
                        conf.setHoraDeFinalizacion(rs.getString("horadefinalizacion"));
                        return conf;
                    });
            return Optional.of(conferencia);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Conferencia> findAll() {
        return jdbcTemplate.query(queryfindall,
                (rs, rowNumber) -> {
                    Conferencia conf = new Conferencia();
                    conf.setId_evento(rs.getInt("id_evento"));
                    conf.setNombre(rs.getString("nombre"));
                    conf.setDescripcion(rs.getString("descripcion"));
                    conf.setHoraDeInicio(rs.getString("horadeinicio"));
                    conf.setHoraDeFinalizacion(rs.getString("horadefinalizacion"));
                    return conf;
                });
    }

    @Override
    public boolean update(Conferencia conferencia) {
        return jdbcTemplate.update(queryUpdate,
                conferencia.getNombre(),
                conferencia.getDescripcion(),
                conferencia.getHoraDeInicio(),
                conferencia.getHoraDeFinalizacion(),
                conferencia.getId_evento()) == 1;
    }

    @Override
    public Conferencia save(Conferencia conferencia) {
        // Build the conferencia parameters we want to save
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("nombre", conferencia.getNombre());
        parameters.put("descripcion", conferencia.getDescripcion());
        parameters.put("horadeinicio", conferencia.getHoraDeInicio());
        parameters.put("horadefinalizacion", conferencia.getHoraDeFinalizacion());

        // Execute the query and get the generated key
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);

        logger.info("Inserting product into database, generated key is: {}", newId);

        // Update the conferencia's ID with the new key
        conferencia.setId_evento((Integer)newId);

        // Return the complete conferencia
        return conferencia;
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id) == 1;
    }
}
