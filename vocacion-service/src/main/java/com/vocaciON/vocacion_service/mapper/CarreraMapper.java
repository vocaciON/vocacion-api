package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.CarreraDTO;
import com.vocaciON.vocacion_service.dto.CarreraDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Carrera;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class CarreraMapper {
    private final ModelMapper modelMapper;

    public CarreraMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public CarreraDTO toDTO(Carrera carrera) {
        return modelMapper.map(carrera, CarreraDTO.class);
    }

    public Carrera toEntity(CarreraDTO carreraDTO) {
        return modelMapper.map(carreraDTO, Carrera.class);
    }
}

