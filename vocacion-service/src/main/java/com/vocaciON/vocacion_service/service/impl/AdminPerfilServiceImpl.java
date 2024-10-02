package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.service.AdminPerfilService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Data

public class AdminPerfilServiceImpl implements AdminPerfilService {

    private final PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Perfil> getAll() {
        return perfilRepository.findAll();//obtener todos
    }
        @Transactional(readOnly = true)
    @Override
    public Perfil findById(Long id) { //buscar
        return perfilRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Estudiante  no encontrado"));

    }

    @Transactional
    @Override
    public Perfil create(Perfil perfil) { //crear
        perfil.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return perfilRepository.save(perfil);
    }

    @Transactional
    @Override
    public Perfil update(Long id, Perfil updatePerfil) {//actualizar
        Perfil perfilFromDB = findById(id);

        perfilFromDB.setDescripcion(updatePerfil.getDescripcion());
        perfilFromDB.setGradoAcademico(updatePerfil.getGradoAcademico());
        perfilFromDB.setEdadEstudiante(updatePerfil.getEdadEstudiante());
        perfilFromDB.setInstitucionEstudio(updatePerfil.getInstitucionEstudio());
        perfilFromDB.setCarrerasInteres(updatePerfil.getCarrerasInteres());



        return perfilRepository.save(perfilFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Perfil perfil = findById(id);
        perfilRepository.delete(perfil);

    }
}