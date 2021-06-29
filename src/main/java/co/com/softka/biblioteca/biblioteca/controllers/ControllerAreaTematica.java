package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.dtos.AreaTematicaDTO;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
import co.com.softka.biblioteca.biblioteca.services.ServiceAreaTematicaCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class ControllerAreaTematica {
    @Autowired
    ServiceAreaTematicaCRUD serviceAreaTematicaCRUD;

    @GetMapping("/{id}")
    public ResponseEntity<AreaTematicaDTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(serviceAreaTematicaCRUD.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AreaTematicaDTO>> findAll() {
        return new ResponseEntity(serviceAreaTematicaCRUD.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<AreaTematicaDTO> create(@RequestBody AreaTematicaDTO areaDTO) {
        return new ResponseEntity(serviceAreaTematicaCRUD.crear(areaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<AreaTematicaDTO> update(@RequestBody AreaTematicaDTO areaDTO) {
        if (areaDTO.getId() != null) {
            return new ResponseEntity(serviceAreaTematicaCRUD.modificar(areaDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            serviceAreaTematicaCRUD.borrar(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
