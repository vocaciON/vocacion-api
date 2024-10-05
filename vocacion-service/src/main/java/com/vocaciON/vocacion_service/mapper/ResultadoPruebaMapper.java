package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.ResultadoPruebaDTO;
import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class ResultadoPruebaMapper {
    private final ModelMapper modelMapper;

    public ResultadoPruebaMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public ResultadoPruebaDTO toDTO(ResultadoPrueba resultadoPrueba) {
        return modelMapper.map(resultadoPrueba, ResultadoPruebaDTO.class);
    }

    public ResultadoPrueba toEntity(ResultadoPruebaDTO resultadoPruebaDTO) {
        return modelMapper.map(resultadoPruebaDTO, ResultadoPrueba.class);
    }
}


