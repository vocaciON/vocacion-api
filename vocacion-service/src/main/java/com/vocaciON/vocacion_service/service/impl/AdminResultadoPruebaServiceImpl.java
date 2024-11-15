package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.ResultadoPruebaDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.ResultadoPruebaMapper;
import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import com.vocaciON.vocacion_service.repository.*;
import com.vocaciON.vocacion_service.service.AdminResultadoPruebaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminResultadoPruebaServiceImpl implements AdminResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PruebaVocacionRepository pruebaVocacionRepository;
    private final CarreraRepository carreraRepository;
    private final PerfilRepository perfilRepository;

    private final ResultadoPruebaMapper resultadoPruebaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPruebaDTO> getAll() {

        List<ResultadoPrueba> resultadoPruebas = resultadoPruebaRepository.findAll();

        return resultadoPruebas.stream().map(resultadoPruebaMapper::toDTO).toList();
    }



    @Transactional
    @Override
    public ResultadoPruebaDTO create(ResultadoPruebaDTO resultadoPruebaDTO) {


        ResultadoPrueba resultadoPrueba = resultadoPruebaMapper.toEntity(resultadoPruebaDTO);
        resultadoPrueba.setFechaCreate(LocalDateTime.now());
        resultadoPrueba = resultadoPruebaRepository.save(resultadoPrueba);

        return resultadoPruebaMapper.toDTO(resultadoPrueba);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultadoPruebaDTO findById(Long id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de la prueba con el id " + id + " no existe"));
        return resultadoPruebaMapper.toDTO(resultadoPrueba);
    }


    @Transactional
    @Override
    public ResultadoPruebaDTO update(Long id, ResultadoPruebaDTO updatedResultadoPruebaDTO) {
        ResultadoPrueba resultadoPruebaFromDB = resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La carrera con el id " + id + " no existe"));


        resultadoPruebaFromDB.setResultado(updatedResultadoPruebaDTO.getResultado());
        resultadoPruebaFromDB.setRecomendaciones(updatedResultadoPruebaDTO.getRecomendaciones());
        resultadoPruebaFromDB.setFeedback(updatedResultadoPruebaDTO.getFeedback());
        resultadoPruebaFromDB.setFechaCreate(LocalDateTime.now());

        resultadoPruebaFromDB = resultadoPruebaRepository.save(resultadoPruebaFromDB);
        return resultadoPruebaMapper.toDTO(resultadoPruebaFromDB);

    }
    @Transactional
    @Override
    public void delete(Long id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Resultado de la prueba con el id " + id + " no existe"));
        resultadoPruebaRepository.delete(resultadoPrueba);

    }
}
