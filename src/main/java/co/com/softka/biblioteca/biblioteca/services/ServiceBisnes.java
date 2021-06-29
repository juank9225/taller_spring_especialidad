package co.com.softka.biblioteca.biblioteca.services;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
import co.com.softka.biblioteca.biblioteca.dtos.RespuestaDTO;
import co.com.softka.biblioteca.biblioteca.mappers.RecursoMapper;
import co.com.softka.biblioteca.biblioteca.repositories.RepositoryRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceBisnes {
    @Autowired
    RepositoryRecurso repositoryRecurso;

    RecursoMapper mapper = new RecursoMapper();

    public RespuestaDTO disponibilidad(String id){
        RespuestaDTO respuesta = new RespuestaDTO();

        Recurso recurso = repositoryRecurso.findById(id).orElseThrow(()->{throw new IllegalArgumentException("no se encontro el recurso."); });
        if (recurso.getDisponible()){
            respuesta.setRespuesta("El recurso: ( "+mapper.fromCollection(recurso).getNombre()+" ) esta disponible.");
            respuesta.setDisponible(true);
            respuesta.setFecha(null);
            return respuesta;

        }
        respuesta.setRespuesta( "El recurso no esta Disponible, la ultima fecha de prestamo es: ( "+mapper.fromCollection(recurso).getFecha().toString()+" )");
        respuesta.setDisponible(false);
        respuesta.setFecha(mapper.fromCollection(recurso).getFecha());
        return respuesta;
    }

    public RespuestaDTO prestarRecurso(String id){
        RespuestaDTO respuesta = new RespuestaDTO();
        LocalDate fecha = LocalDate.now();
        Recurso recurso = repositoryRecurso.findById(id).orElseThrow(()->{throw new IllegalArgumentException("no se encontro el recurso."); });
        if (recurso.getDisponible()){
           recurso.setDisponible(false);
           recurso.setFecha(fecha);
           repositoryRecurso.save(recurso);
           respuesta.setRespuesta("El recurso: ("+mapper.fromCollection(recurso).getNombre()+" ) ha sido prestado.");
           respuesta.setDisponible(false);
           respuesta.setFecha(mapper.fromCollection(recurso).getFecha());
           return respuesta;

        }
        respuesta.setRespuesta("El recurso: ( "+mapper.fromCollection(recurso).getNombre()+" ) no se encuentra disponible.");
        respuesta.setDisponible(false);
        respuesta.setFecha(mapper.fromCollection(recurso).getFecha());
        return respuesta;
    }

    public RespuestaDTO devolverRecurso(String id){
        RespuestaDTO respuesta = new RespuestaDTO();
        LocalDate fecha = LocalDate.now();
        Recurso recurso = repositoryRecurso.findById(id).orElseThrow(()->{throw new IllegalArgumentException("no se encontro el recurso."); });
        if (!recurso.getDisponible()){
            recurso.setDisponible(true);
            recurso.setFecha(fecha);
            repositoryRecurso.save(recurso);
            respuesta.setRespuesta("El recurso: ( "+mapper.fromCollection(recurso).getNombre()+" ) ha sido devuelto.");
            respuesta.setDisponible(true);
            respuesta.setFecha(mapper.fromCollection(recurso).getFecha());
            return respuesta;
        }
        respuesta.setRespuesta("El recurso: ( "+mapper.fromCollection(recurso).getNombre()+" ) no esta en prestamo.");
        respuesta.setDisponible(false);
        respuesta.setFecha(mapper.fromCollection(recurso).getFecha());
        return respuesta;
    }

    public List<RecursoDTO> recomendarRecurso(String areaId){
        List<Recurso> recursosXarea= (List<Recurso>) repositoryRecurso.findByareaTematicaId(areaId).orElseThrow(()->{throw new IllegalArgumentException("no se encontraron registros");});
        return mapper.fromCollectionList(recursosXarea);
    }
}
