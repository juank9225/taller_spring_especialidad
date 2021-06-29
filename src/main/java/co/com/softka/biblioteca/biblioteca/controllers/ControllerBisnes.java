package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.dtos.ListarRecursosPorAreasDTO;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
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

    @GetMapping("/recomendacion/tipo/{id}")
    public ResponseEntity<List<RecursoDTO>> recomendarTipo(@PathVariable("id") String tipo){
        return new ResponseEntity(serviceBisnes.recomendarPorTipo(tipo),HttpStatus.OK);
    }

    @GetMapping("/recomendacion/area/tipo/{area}/{tipo}")
    public ResponseEntity<List<RecursoDTO>> recomendarTipo(@PathVariable("area") String area,@PathVariable("tipo") String tipo){
        return new ResponseEntity(serviceBisnes.recomendarForAreaAndTipo(area,tipo),HttpStatus.OK);
    }
}
