package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.model.entity.Asesoria;
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
        asesoria.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return asesoriaRepository.save(asesoria);
    }

    @Transactional
    @Override
    public Asesoria update(Long id, Asesoria updateAsesoria) {//actualizar
        Asesoria asesoriaFromDB = findById(id);

        asesoriaFromDB.setTemaTratar(updateAsesoria.getTemaTratar());
        asesoriaFromDB.setFechaAsesoria(updateAsesoria.getFechaAsesoria());
        asesoriaFromDB.setCosto(updateAsesoria.getCosto());
        asesoriaFromDB.setCreatedAt(LocalDateTime.now());
        asesoriaFromDB.setLinkAsesoria(updateAsesoria.getLinkAsesoria());




        return asesoriaRepository.save(asesoriaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Asesoria asesoria = findById(id);
        asesoriaRepository.delete(asesoria);

    }

}
