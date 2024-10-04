package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.RespuestaDTO;
import com.vocaciON.vocacion_service.model.entity.Respuesta;
import com.vocaciON.vocacion_service.repository.RespuestaRepository;
import com.vocaciON.vocacion_service.service.AdminRespuestaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/respuestas")

public class AdminRespuestaController {

    private final AdminRespuestaService adminRespuestaService;
    private final RespuestaRepository respuestaRepository;

    //vamos con los metodos
    // Responder las listas

    @GetMapping
    public ResponseEntity<List<RespuestaDTO>> getListaRespuesta() {
        List<RespuestaDTO> respuestas = adminRespuestaService.getAll();
        return new ResponseEntity<>(respuestas, HttpStatus.OK); //ok = 200
    }


    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaDTO> getRespuestaById(@PathVariable("id") Long id) {
        RespuestaDTO respuesta = adminRespuestaService.findById(id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<RespuestaDTO> create(@Valid @RequestBody RespuestaDTO respuestaDTO) {

        RespuestaDTO createRespuesta = adminRespuestaService.create(respuestaDTO);
        return new ResponseEntity<>(createRespuesta, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<RespuestaDTO> update(@PathVariable("id") Long id, @Valid @RequestBody RespuestaDTO respuestaDTO) {

        RespuestaDTO updateRespuesta = adminRespuestaService.update(id, respuestaDTO);
        return new ResponseEntity<>(updateRespuesta, HttpStatus.OK);
    }
}
