package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.ContenidoEducativoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDetailsDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class AdminContenidoEducativoServiceImpl implements AdminContenidoEducativoService {

    private final ContenidoEducativoRepository contenidoEducativoRepository;
    private final PerfilRepository perfilRepository;

    private final ContenidoEducativoMapper contenidoEducativoMapper;


    @Transactional(readOnly = true)
    @Override
    public List<ContenidoEducativoDetailsDTO> findAll() {

        List<ContenidoEducativo> contenidoEducativos = contenidoEducativoRepository.findAll();

        return contenidoEducativos.stream().map(contenidoEducativoMapper::toDetailsDTO).toList();
    }

    @Transactional
    @Override
    public ContenidoEducativoDetailsDTO create(ContenidoEducativoCreateUpdateDTO contenidoEducativoCreateUpdateDTO) { //crear

        ContenidoEducativo contenidoEducativo = contenidoEducativoMapper.toEntity(contenidoEducativoCreateUpdateDTO);

        contenidoEducativo.setCreatedAt(LocalDateTime.now());
        contenidoEducativo = contenidoEducativoRepository.save(contenidoEducativo);

        return contenidoEducativoMapper.toDetailsDTO(contenidoEducativo);
    }







    @Override
    public ContenidoEducativoDetailsDTO findById(Long id) { //buscar
        ContenidoEducativo contenidoEducativo = contenidoEducativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido Educativo con el id " + id + " no existe"));
        return contenidoEducativoMapper.toDetailsDTO(contenidoEducativo);
    }

    @Override
    public ContenidoEducativoDetailsDTO update(Long id, ContenidoEducativoCreateUpdateDTO updateContenidoEducativoDTO) {//actualizar


        ContenidoEducativo contenidoEducativoFromDB = contenidoEducativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El contenido Educativo con el id " + id + " no existe"));

        /*Perfil perfil = perfilRepository.findById(updateContenidoEducativoDTO.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ updateContenidoEducativo.getPerfil().getId()));*/



        contenidoEducativoFromDB.setTituloContenido(updateContenidoEducativoDTO.getTituloContenido());
        contenidoEducativoFromDB.setLink(updateContenidoEducativoDTO.getLink());
        contenidoEducativoFromDB.setContenido(updateContenidoEducativoDTO.getContenido());


        /*contenidoEducativoFromDB.setPerfil(perfil);*/


        contenidoEducativoFromDB = contenidoEducativoRepository.save(contenidoEducativoFromDB);
        return contenidoEducativoMapper.toDetailsDTO(contenidoEducativoFromDB);
    }

    @Override
    public void delete(Long id) {
        ContenidoEducativo contenidoEducativo = contenidoEducativoRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Contenido Educativo con el id " + id + " no existe"));
        contenidoEducativoRepository.delete(contenidoEducativo);

    }

    @Override
    public List<ContenidoEducativoDetailsDTO> findTop6ContenidoEducativoByCreatedAt() {
        return contenidoEducativoRepository.findTop6ByOrderByCreatedAtDesc()
                .stream()
                .map(contenidoEducativoMapper::toDetailsDTO)
                .toList();
    }


}
