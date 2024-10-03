package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.service.AdminPreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/preguntas")

public class AdminPreguntaController {

    private final AdminPreguntaService adminPreguntaService;

    //vamos con los metodos
    // Responder las listas

    @GetMapping
    public ResponseEntity<List<Pregunta>> getListaPregunta(){
        List<Pregunta> preguntas = adminPreguntaService.getAll();
        return new ResponseEntity<List<Pregunta>>(preguntas, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable("id") Long id){
        Pregunta pregunta = adminPreguntaService.findById(id);
        return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta){

        Pregunta newPregunta = adminPreguntaService.create(pregunta);
        return new ResponseEntity<Pregunta>(newPregunta, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> updatePregunta(@PathVariable("id") Long id,
                                                   @RequestBody Pregunta pregunta){

        Pregunta updatePregunta = adminPreguntaService.update(id,pregunta);
        return new ResponseEntity<Pregunta>(updatePregunta, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pregunta> deletePregunta(@PathVariable("id") Long id,
                                                   @RequestBody Pregunta pregunta){

        adminPreguntaService.delete(id);
        return new ResponseEntity<Pregunta>(HttpStatus.NO_CONTENT);

    }
}
