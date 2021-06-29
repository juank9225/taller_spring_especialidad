package co.com.softka.biblioteca.biblioteca.mappers;

import co.com.softka.biblioteca.biblioteca.collections.AreaTematica;
import co.com.softka.biblioteca.biblioteca.dtos.AreaTematicaDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaTematicaMapper {

    public AreaTematica fromDTO(AreaTematicaDTO dto) {
        AreaTematica area = new AreaTematica();
        area.setId(dto.getId());
        area.setNombre(dto.getNombre());

        return area;
    }

    public AreaTematicaDTO fromCollection(AreaTematica collection) {
        AreaTematicaDTO areaDTO = new AreaTematicaDTO();
        areaDTO.setId(collection.getId());
        areaDTO.setNombre(collection.getNombre());

        return areaDTO;
    }

    public List<AreaTematicaDTO> fromCollectionList(List<AreaTematica> collection) {
        if (collection == null) {
            return null;

        }
        List<AreaTematicaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            AreaTematica area = (AreaTematica) listTracks.next();
            list.add(fromCollection(area));
        }

        return list;
    }
}
