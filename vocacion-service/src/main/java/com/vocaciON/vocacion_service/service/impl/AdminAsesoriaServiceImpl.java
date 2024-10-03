package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
import com.vocaciON.vocacion_service.repository.AsesoriaRepository;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.service.AdminAsesoriaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminAsesoriaServiceImpl implements AdminAsesoriaService {

    private final AsesoriaRepository asesoriaRepository;
    private final ExpertoRepository expertoRepository;
    private final PerfilRepository perfilRepository;




    @Transactional(readOnly = true)
    @Override
    public List<Asesoria> getAll() {
        return asesoriaRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public Asesoria findById(Long id) { //buscar
        return asesoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Asesoria  no encontrado"));

    }

    @Transactional
    @Override
    public Asesoria create(Asesoria asesoria) { //crear

        Experto experto = expertoRepository.findById(asesoria.getExperto().getId())
                .orElseThrow(() -> new RuntimeException("Experto no encontrado"+ asesoria.getExperto().getId()));

        Perfil perfil = perfilRepository.findById(asesoria.getPerfil().getId())
                        .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ asesoria.getPerfil().getId()));
        //Crear el estado de la asesoria
        //**************************************************************
        asesoria.setEstadoAsesoria(EstadoAsesoria.PENDIENTE);
        //*************************************************************
        asesoria.setExperto(experto);
        asesoria.setPerfil(perfil);
        asesoria.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return asesoriaRepository.save(asesoria);
    }

    @Transactional
    @Override
    public Asesoria update(Long id, Asesoria updateAsesoria) {//actualizar
        Asesoria asesoriaFromDB = findById(id);

        Experto experto = expertoRepository.findById(updateAsesoria.getExperto().getId())
                        .orElseThrow(() -> new RuntimeException("Experto no encontrado"+ updateAsesoria.getExperto().getId()));
        Perfil perfil = perfilRepository.findById(updateAsesoria.getPerfil().getId())
                        .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ updateAsesoria.getPerfil().getId()));

        asesoriaFromDB.setTemaTratar(updateAsesoria.getTemaTratar());
        asesoriaFromDB.setFechaAsesoria(updateAsesoria.getFechaAsesoria());
        asesoriaFromDB.setCosto(updateAsesoria.getCosto());
        asesoriaFromDB.setCreatedAt(LocalDateTime.now());
        asesoriaFromDB.setLinkAsesoria(updateAsesoria.getLinkAsesoria());

        asesoriaFromDB.setExperto(experto);
        asesoriaFromDB.setPerfil(perfil);




        return asesoriaRepository.save(asesoriaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Asesoria asesoria = findById(id);
        asesoriaRepository.delete(asesoria);

    }

}
