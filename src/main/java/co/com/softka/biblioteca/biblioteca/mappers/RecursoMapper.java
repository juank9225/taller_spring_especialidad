package co.com.softka.biblioteca.biblioteca.mappers;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursoMapper {

    public Recurso fromDTO(RecursoDTO dto) {
        Recurso recurso = new Recurso();
        recurso.setId(dto.getId());
        recurso.setNombre(dto.getNombre());
        recurso.setTipoRecurso(dto.getTipoRecurso());
        recurso.setFecha(dto.getFecha());
        recurso.setDisponible(dto.getDisponible());
        recurso.setAreaTematicaId(dto.getAreaTematicaId());

        return recurso;
    }

    public RecursoDTO fromCollection(Recurso collection) {
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setId(collection.getId());
        recursoDTO.setNombre(collection.getNombre());
        recursoDTO.setTipoRecurso(collection.getTipoRecurso());
        recursoDTO.setFecha(collection.getFecha());
        recursoDTO.setDisponible(collection.getDisponible());
        recursoDTO.setAreaTematicaId(collection.getAreaTematicaId());

        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<Recurso> collection) {
        if (collection == null) {
            return null;

        }
        List<RecursoDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Recurso recurso = (Recurso) listTracks.next();
            list.add(fromCollection(recurso));
        }

        return list;
    }
}
