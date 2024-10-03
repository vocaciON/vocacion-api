package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.Respuesta;
import com.vocaciON.vocacion_service.service.AdminRespuestaService;
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

    //vamos con los metodos
    // Responder las listas

    @GetMapping
    public ResponseEntity<List<Respuesta>> getListaRespuesta(){
        List<Respuesta> respuestas = adminRespuestaService.getAll();
        return new ResponseEntity<List<Respuesta>>(respuestas, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> getRespuestaById(@PathVariable("id") Long id){
        Respuesta respuesta = adminRespuestaService.findById(id);
        return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta){

        Respuesta newRespuesta = adminRespuestaService.create(respuesta);
        return new ResponseEntity<Respuesta>(newRespuesta, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> updateRespuesta(@PathVariable("id") Long id,
                                                   @RequestBody Respuesta respuesta){

        Respuesta updateRespuesta = adminRespuestaService.update(id,respuesta);
        return new ResponseEntity<Respuesta>(updateRespuesta, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> deleteRespuesta(@PathVariable("id") Long id,
                                                   @RequestBody Respuesta respuesta){

        adminRespuestaService.delete(id);
        return new ResponseEntity<Respuesta>(HttpStatus.NO_CONTENT);

    }
}
