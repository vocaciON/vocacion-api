package com.vocaciON.vocacion_service.service.impl;
// Estas clases van a contener la implementacion

import com.vocaciON.vocacion_service.model.entity.PruebaVocacional;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.service.AdminExpertoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminExpertoServiceImpl implements AdminExpertoService {

    private final ExpertoRepository expertoRepository;


    @Transactional(readOnly = true)
    @Override
    public List<PruebaVocacional> getAll() {
        return expertoRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public PruebaVocacional findById(Long id) { //buscar
        return expertoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Experto  no encontrado"));

    }

    @Transactional
    @Override
    public PruebaVocacional create(PruebaVocacional experto) { //crear
        experto.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return expertoRepository.save(experto);
    }

    @Transactional
    @Override
    public PruebaVocacional update(Long id, PruebaVocacional updateExperto) {//actualizar
        PruebaVocacional expertoFromDB = findById(id);
        expertoFromDB.setNombre(updateExperto.getNombre());
        expertoFromDB.setApellido(updateExperto.getApellido());
        expertoFromDB.setArea(updateExperto.getArea());
        expertoFromDB.setDescripcion(updateExperto.getDescripcion());
        expertoFromDB.setDisponibilidad(updateExperto.getDisponibilidad());


        return expertoRepository.save(expertoFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        PruebaVocacional experto = findById(id);
        expertoRepository.delete(experto);

    }
}
