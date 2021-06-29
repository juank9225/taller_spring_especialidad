package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.dtos.ListarRecursosPorAreasDTO;
import co.com.softka.biblioteca.biblioteca.dtos.RespuestaDTO;
import co.com.softka.biblioteca.biblioteca.services.ServiceBisnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
public class ControllerBisnes {

    @Autowired
    ServiceBisnes serviceBisnes;

    @GetMapping("/disponibilidad/{id}")
    public ResponseEntity<RespuestaDTO> disponibilidadRecurso(@PathVariable("id") String id) {
        return new ResponseEntity(serviceBisnes.disponibilidad(id), HttpStatus.OK);
    }

    @GetMapping("/prestamo/{id}")
    public ResponseEntity<RespuestaDTO> prestarRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceBisnes.prestarRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/devolver/{id}")
    public ResponseEntity<RespuestaDTO> devolverRecurso(@PathVariable("id") String id){
        return new ResponseEntity(serviceBisnes.devolverRecurso(id),HttpStatus.OK);
    }

    @GetMapping("/recomendacion/{id}")
    public ResponseEntity<ListarRecursosPorAreasDTO> recomendar(@PathVariable("id") String areaId){
        return new ResponseEntity(serviceBisnes.recomendarRecurso(areaId),HttpStatus.OK);
    }
}
