package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.mapper.PreguntaMapper;
import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.repository.PreguntaRepository;
import com.vocaciON.vocacion_service.repository.PruebaVocacionRepository;
import com.vocaciON.vocacion_service.service.AdminPreguntaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor

public class AdminPreguntaServiceImpl implements AdminPreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final PruebaVocacionRepository pruebaVocacionRepository;

    private final PreguntaMapper preguntaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Pregunta> getAll() {
        return preguntaRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public Pregunta findById(Long id) { //buscar
        return preguntaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pregunta  no encontrado"));

    }

    @Transactional
    @Override
    public Pregunta create(Pregunta pregunta) { //crear
        pregunta.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return preguntaRepository.save(pregunta);
    }

    @Transactional
    @Override
    public Pregunta update(Long id, Pregunta updatePregunta) {//actualizar
        Pregunta preguntaFromDB = findById(id);

        preguntaFromDB.setDescripcion(updatePregunta.getDescripcion());






        return preguntaRepository.save(preguntaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Pregunta pregunta = findById(id);
        preguntaRepository.delete(pregunta);

    }
}
