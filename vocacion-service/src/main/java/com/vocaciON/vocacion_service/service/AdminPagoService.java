package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PagoCreateDTO;
import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.dto.PagoReportDTO;


import java.util.List;

public interface AdminPagoService {

// Creacion de una compra
    PagoDTO createPago(PagoCreateDTO pagoCreateDTO);

    // Listar todos los pagos
    List<PagoDTO> getAllPagos();


    //Historial de compras por usuario
    List<PagoDTO> getPagoHistoryByUsuarioId(long usuarioId);

    //Metodo para buscar mediante ID
    PagoDTO findById(Long id);

    //Eliminacion del objeto pago
    void delete(Long id);
    //Agregando un nuevo metodo , Retornar una lista de tipo PagosReportDTO
    List<PagoReportDTO> getPagoReportByDate();

    PagoDTO confirmPago(Long pagoId);

    PagoDTO getPagoById(Long id);
}
