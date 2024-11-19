package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.PreguntaDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.PreguntaMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
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
    public List<PreguntaDTO> getAll() {

        List<Pregunta> preguntas = preguntaRepository.findAll();

        return preguntas.stream().map(preguntaMapper::toDTO).toList();
    }



    @Transactional(readOnly = true)
    @Override
    public PreguntaDTO findById(Long id) { //buscar
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta con el id " + id + " no existe"));
        return preguntaMapper.toDTO(pregunta);



    }

    @Transactional
    @Override
    public PreguntaDTO create(PreguntaDTO preguntaDTO) { //crear

        Pregunta pregunta = preguntaMapper.toEntity(preguntaDTO);
        pregunta.setFechaCreate(LocalDateTime.now());
        pregunta = preguntaRepository.save(pregunta);


        //**************************************************************

        //*************************************************************


        return preguntaMapper.toDTO(pregunta);
    }

    @Transactional
    @Override
    public PreguntaDTO update(Long id, PreguntaDTO updatePreguntaDTO) {//actualizar
        Pregunta preguntaFromDB = preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La Pregunta con el id " + id + " no existe"));

        preguntaFromDB.setDescripcion(updatePreguntaDTO.getDescripcion());

        preguntaFromDB = preguntaRepository.save(preguntaFromDB);
        return preguntaMapper.toDTO(preguntaFromDB);



    }



    @Transactional
    @Override
    public void delete(Long id) {
        Pregunta pregunta = preguntaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Asesoria con el id " + id + " no existe"));
        preguntaRepository.delete(pregunta);

    }
}
