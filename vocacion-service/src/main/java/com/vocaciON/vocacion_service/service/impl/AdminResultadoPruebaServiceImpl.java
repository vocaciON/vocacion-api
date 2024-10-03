package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.*;
import com.vocaciON.vocacion_service.repository.*;
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
    private final UsuarioRepository usuarioRepository;
    private final PruebaVocacionRepository pruebaVocacionRepository;
    private final CarreraRepository carreraRepository;
    private final PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPrueba> getAll() {
        return resultadoPruebaRepository.findAll(); // Obtener toda la lista
    }

    @Transactional
    @Override
    public ResultadoPrueba create(ResultadoPrueba resultadoPrueba) {

        Usuario usuario = usuarioRepository.findById(resultadoPrueba.getUsuario().getId()).
                orElseThrow(() -> new RuntimeException("Usuario no encontrado"+resultadoPrueba.getUsuario().getId()));

        Carrera carrera = carreraRepository.findById(resultadoPrueba.getCarrera().getId()).
                orElseThrow(() -> new RuntimeException("Carrera no encontrado"+resultadoPrueba.getCarrera().getId()));

        Perfil perfil = perfilRepository.findById(resultadoPrueba.getPerfil().getId()).
                orElseThrow(() -> new RuntimeException("Perfil no encontrado"+resultadoPrueba.getPerfil().getId()));

        PruebaVocacion pruebaVocacion = pruebaVocacionRepository.findById(resultadoPrueba.getPruebaVocacion().getId()).
                orElseThrow(() -> new RuntimeException("Prueba Vocacional no encontrado"+resultadoPrueba.getPruebaVocacion().getId()));







        resultadoPrueba.setPerfil(perfil);
        resultadoPrueba.setCarrera(carrera);

        resultadoPrueba.setPruebaVocacion(pruebaVocacion);
        resultadoPrueba.setUsuario(usuario);

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
    public ResultadoPrueba update(Long id, ResultadoPrueba updatedResultadoPrueba) {
        ResultadoPrueba resultadoPruebaFromDB = findById(id);

        Usuario usuario = usuarioRepository.findById(updatedResultadoPrueba.getUsuario().getId()).
                orElseThrow(() -> new RuntimeException("Usuario no encontrado"+updatedResultadoPrueba.getUsuario().getId()));

        Carrera carrera = carreraRepository.findById(updatedResultadoPrueba.getCarrera().getId()).
                orElseThrow(() -> new RuntimeException("Carrera no encontrado"+updatedResultadoPrueba.getCarrera().getId()));

        Perfil perfil = perfilRepository.findById(updatedResultadoPrueba.getPerfil().getId()).
                orElseThrow(() -> new RuntimeException("Perfil no encontrado"+updatedResultadoPrueba.getPerfil().getId()));

        PruebaVocacion pruebaVocacion = pruebaVocacionRepository.findById(updatedResultadoPrueba.getPruebaVocacion().getId()).
                orElseThrow(() -> new RuntimeException("Prueba Vocacional no encontrado"+updatedResultadoPrueba.getPruebaVocacion().getId()));


        resultadoPruebaFromDB.setResultado(updatedResultadoPrueba.getResultado());
        resultadoPruebaFromDB.setRecomendaciones(updatedResultadoPrueba.getRecomendaciones());
        resultadoPruebaFromDB.setFeedback(updatedResultadoPrueba.getFeedback());

        resultadoPruebaFromDB.setPerfil(perfil);
        resultadoPruebaFromDB.setPruebaVocacion(pruebaVocacion);
        resultadoPruebaFromDB.setUsuario(usuario);
        resultadoPruebaFromDB.setCarrera(carrera);


        return resultadoPruebaRepository.save(resultadoPruebaFromDB);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        ResultadoPrueba usuario = findById(id);
        resultadoPruebaRepository.delete(usuario);

    }
}
