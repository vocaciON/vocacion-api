package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.repository.PruebaVocacionRepository;
import com.vocaciON.vocacion_service.service.AdminPruebaVocacionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data


public class AdminPruebaVocacionServiceImpl implements AdminPruebaVocacionService {

    private final PruebaVocacionRepository pruebaVocacionRepository;

    private final PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PruebaVocacion> getAll() {

        return pruebaVocacionRepository.findAll(); //optener toda la lista
    }

    @Transactional
    @Override
    public PruebaVocacion create(PruebaVocacion pruebaVocacion) {

        Perfil perfil = perfilRepository.findById(pruebaVocacion.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ pruebaVocacion.getPerfil().getId()));

        pruebaVocacion.setPerfil(perfil);

        PruebaVocacion.setCreatedAd(LocalDateTime.now()); // setear la fecha de creacion
        return pruebaVocacionRepository.save(pruebaVocacion);
    }

    @Transactional(readOnly = true)
    @Override
    public PruebaVocacion findById(Long id) {
        return pruebaVocacionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pruebas vocacional no encontradas"));

    }
    @Transactional
    @Override
    public PruebaVocacion update(Long id, PruebaVocacion UpdatePruebaVocacion) {
        PruebaVocacion pruebaVocacionFromDB = findById(id);


        Perfil perfil = perfilRepository.findById(UpdatePruebaVocacion.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ UpdatePruebaVocacion.getPerfil().getId()));

        pruebaVocacionFromDB.setNombre(UpdatePruebaVocacion.getNombre());
        pruebaVocacionFromDB.setDescripcion(UpdatePruebaVocacion.getDescripcion());
        pruebaVocacionFromDB.setTipo(UpdatePruebaVocacion.getTipo());
        pruebaVocacionFromDB.setLimiteTiempo(UpdatePruebaVocacion.getLimiteTiempo());
        pruebaVocacionFromDB.setPreguntas(UpdatePruebaVocacion.getPreguntas());
        pruebaVocacionFromDB.setRespuestas(UpdatePruebaVocacion.getRespuestas());
        pruebaVocacionFromDB.setPerfil(perfil);

        return pruebaVocacionRepository.save(pruebaVocacionFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        PruebaVocacion pruebaVocacion = findById(id);
        pruebaVocacionRepository.delete(pruebaVocacion);

    }
}
