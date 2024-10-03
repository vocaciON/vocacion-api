package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.model.entity.Respuesta;
import com.vocaciON.vocacion_service.repository.PreguntaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaUsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminRespuestaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.time.LocalDateTime;


@Service
@Data
@RequiredArgsConstructor


public class AdminRespuestaServiceImpl implements AdminRespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Respuesta> getAll() {

        return respuestaRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public Respuesta findById(Long id) { //buscar
        return respuestaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Respuesta no encontrado"));

    }

    @Transactional
    @Override
    public Respuesta create(Respuesta respuesta) { //crear

        Pregunta pregunta = preguntaRepository.findById(respuesta.getPregunta().getId())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrado"+respuesta.getPregunta().getId()));

        respuesta.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        respuesta.setPregunta(pregunta);
        return respuestaRepository.save(respuesta);
    }

    @Transactional
    @Override
    public Respuesta update(Long id, Respuesta updateRespuesta) {//actualizar
        Respuesta respuestaFromDB = findById(id);
        Pregunta pregunta = preguntaRepository.findById(updateRespuesta.getPregunta().getId())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrado"+updateRespuesta.getPregunta().getId()));



        respuestaFromDB.setPregunta(pregunta);





        return respuestaRepository.save(respuestaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Respuesta respuesta = findById(id);
        respuestaRepository.delete(respuesta);

    }
}
