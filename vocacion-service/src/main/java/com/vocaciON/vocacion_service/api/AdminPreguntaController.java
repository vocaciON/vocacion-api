package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.PreguntaDTO;
import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.service.AdminPreguntaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/preguntas")
@PreAuthorize("hastRole('ADMIN')")

public class AdminPreguntaController {

    private final AdminPreguntaService adminPreguntaService;

    //vamos con los metodos
    // Responder las listas

    @GetMapping
    public ResponseEntity<List<PreguntaDTO>> getListaPregunta(){
        List<PreguntaDTO> preguntas = adminPreguntaService.getAll();
        return new ResponseEntity<>(preguntas, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<PreguntaDTO> getPreguntaById(@PathVariable("id") Long id){
        PreguntaDTO pregunta = adminPreguntaService.findById(id);
        return new ResponseEntity<>(pregunta, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<PreguntaDTO> create(@Valid @RequestBody PreguntaDTO preguntaDTO){

        PreguntaDTO createPregunta = adminPreguntaService.create(preguntaDTO);
        return new ResponseEntity<>(createPregunta, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<PreguntaDTO> update(@PathVariable("id") Long id,@Valid@RequestBody PreguntaDTO preguntaDTO){

        PreguntaDTO updatePregunta = adminPreguntaService.update(id,preguntaDTO);
        return new ResponseEntity<>(updatePregunta, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminPreguntaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
