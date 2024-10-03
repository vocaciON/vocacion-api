package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.repository.ContenidoEducativoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.service.AdminContenidoEducativoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class AdminContenidoEducativoServiceImpl implements AdminContenidoEducativoService {

    private final ContenidoEducativoRepository contenidoEducativoRepository;
    private final PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    @Override
    public List getAll() {
        return contenidoEducativoRepository.findAll();
    }

    @Transactional
    @Override
    public ContenidoEducativo create(ContenidoEducativo contenidoEducativo) {
        return contenidoEducativoRepository.save(contenidoEducativo);
    }

    @Override
    public ContenidoEducativo findById(Long id) {
        return contenidoEducativoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Contenido educativo no encontrado"));
    }

    @Override
    public ContenidoEducativo update(Long id, ContenidoEducativo updateContenidoEducativo) {
        ContenidoEducativo contenidoEducativoFromDB = findById(id);


        contenidoEducativoFromDB.setTipo(updateContenidoEducativo.getTipo());
        contenidoEducativoFromDB.setContenido(updateContenidoEducativo.getContenido());
        contenidoEducativoFromDB.setFavorito(updateContenidoEducativo.getFavorito());
        contenidoEducativoFromDB.setTituloContenido(updateContenidoEducativo.getTituloContenido());
        contenidoEducativoFromDB.setLink(updateContenidoEducativo.getLink());


        return contenidoEducativoRepository.save(contenidoEducativoFromDB);
    }

    @Override
    public void delete(Long id) {
        ContenidoEducativo contenidoEducativo = findById(id);
        contenidoEducativoRepository.delete(contenidoEducativo);

    }






}
