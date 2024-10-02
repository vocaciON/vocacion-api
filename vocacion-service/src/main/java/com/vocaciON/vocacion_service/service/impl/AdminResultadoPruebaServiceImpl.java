package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.repository.PruebaVocacionRepository;
import com.vocaciON.vocacion_service.repository.ResultadoPruebaRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepositoy;
import com.vocaciON.vocacion_service.service.AdminResultadoPruebaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminResultadoPruebaServiceImpl implements AdminResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;


    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPrueba> getAll() {
        return resultadoPruebaRepository.findAll(); // Obtener toda la lista
    }

    @Transactional
    @Override
    public ResultadoPrueba create(ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultadoPrueba findById(Long id) {
        return resultadoPruebaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Resultados de Pruebas  no encontrado"));
    }

    @Transactional
    @Override
    public ResultadoPrueba update(Long id, ResultadoPrueba resultadoPruebaUpdate) {
        ResultadoPrueba resultadoPruebaFromDB = findById(id);
        resultadoPruebaFromDB.setResultado(resultadoPruebaUpdate.getResultado());
        resultadoPruebaFromDB.setRecomendaciones(resultadoPruebaUpdate.getRecomendaciones());


        return resultadoPruebaRepository.save(resultadoPruebaFromDB);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        ResultadoPrueba usuario = findById(id);
        resultadoPruebaRepository.delete(usuario);

    }
}
