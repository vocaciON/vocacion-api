package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.mapper.ContenidoEducativoMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.repository.ContenidoEducativoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.service.AdminContenidoEducativoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class AdminContenidoEducativoServiceImpl implements AdminContenidoEducativoService {

    private final ContenidoEducativoRepository contenidoEducativoRepository;
    private final PerfilRepository perfilRepository;

    private final ContenidoEducativoMapper contenidoEducativoMapper;


    @Transactional(readOnly = true)
    @Override
    public List<ContenidoEducativoDTO> getAll() {

        List<ContenidoEducativo> contenidoEducativos = contenidoEducativoRepository.findAll();

        return contenidoEducativos.stream().map(contenidoEducativoMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public ContenidoEducativoDTO create(ContenidoEducativoDTO contenidoEducativoDTO) { //crear

        ContenidoEducativo contenidoEducativo = contenidoEducativoMapper.toEntity(contenidoEducativoDTO);
        contenidoEducativo.setFechaCreate(LocalDateTime.now());
        contenidoEducativo = contenidoEducativoRepository.save(contenidoEducativo);

        return contenidoEducativoMapper.toDTO(contenidoEducativo);
    }







    @Override
    public ContenidoEducativoDTO findById(Long id) { //buscar
        ContenidoEducativo contenidoEducativo = contenidoEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contenido Educativo con el id " + id + " no existe"));
        return contenidoEducativoMapper.toDTO(contenidoEducativo);
    }

    @Override
    public ContenidoEducativoDTO update(Long id, ContenidoEducativoDTO updateContenidoEducativoDTO) {//actualizar
        ContenidoEducativo contenidoEducativoFromDB = contenidoEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El contenido Educativo con el id " + id + " no existe"));

        /*Perfil perfil = perfilRepository.findById(updateContenidoEducativoDTO.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ updateContenidoEducativo.getPerfil().getId()));*/



        contenidoEducativoFromDB.setContenido(updateContenidoEducativoDTO.getContenido());
        contenidoEducativoFromDB.setFavorito(updateContenidoEducativoDTO.getFavorito());
        contenidoEducativoFromDB.setTituloContenido(updateContenidoEducativoDTO.getTituloContenido());


        /*contenidoEducativoFromDB.setPerfil(perfil);*/


        contenidoEducativoFromDB = contenidoEducativoRepository.save(contenidoEducativoFromDB);
        return contenidoEducativoMapper.toDTO(contenidoEducativoFromDB);
    }

    @Override
    public void delete(Long id) {
        ContenidoEducativo contenidoEducativo = contenidoEducativoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Contenido Educativo con el id " + id + " no existe"));
        contenidoEducativoRepository.delete(contenidoEducativo);

    }






}
