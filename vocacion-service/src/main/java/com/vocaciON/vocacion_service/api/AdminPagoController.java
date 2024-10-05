package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/pagos")

public class AdminPagoController {

    private final AdminPagoService adminPagoService;

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        Pago savedPago = adminPagoService.createPago(pago);
        return new ResponseEntity<>(savedPago, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Pago>> getPagoHistoryByUsuarioId(@PathVariable Long usuarioId) {
        List<Pago> pagoHistory = adminPagoService.getPagoHistoryByUsuarioId(usuarioId);
        return ResponseEntity.ok(pagoHistory);
    }
}
