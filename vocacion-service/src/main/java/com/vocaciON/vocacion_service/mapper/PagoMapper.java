package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Pago;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class PagoMapper {
    private final ModelMapper modelMapper;

    public PagoMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

        public PagoDTO toDTO(Pago pago) {
        return modelMapper.map(pago, PagoDTO.class);
    }

    public Pago toEntity(PagoDTO pagoDTO) {
        return modelMapper.map(pagoDTO, Pago.class);
    }
}
