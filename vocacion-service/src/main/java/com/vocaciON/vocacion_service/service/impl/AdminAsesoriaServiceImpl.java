package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.repository.AsesoriaRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List getAll() {return asesoriaRepository.findAll();}

    @Override
    public Asesoria create(Asesoria asesoria) {
        return asesoriaRepository.save(asesoria);
    }

    @Override
    public Asesoria findById(Long id) {
        return asesoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Asesoria no encontrada"));
    }

    @Override
    public Asesoria update(Long id, Asesoria updateAsesoria) {

        Asesoria asesoriaFromDB = findById(id);

        asesoriaFromDB.setFecha(updateAsesoria.getFecha());
        asesoriaFromDB.setEstado(updateAsesoria.getEstado());

        return asesoriaRepository.save(asesoriaFromDB);
    }

    @Override
    public void delete(Long id) {

    }

}
