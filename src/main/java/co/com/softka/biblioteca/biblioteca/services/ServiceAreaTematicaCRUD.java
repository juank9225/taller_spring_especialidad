package co.com.softka.biblioteca.biblioteca.services;

import co.com.softka.biblioteca.biblioteca.collections.AreaTematica;
import co.com.softka.biblioteca.biblioteca.dtos.AreaTematicaDTO;
import co.com.softka.biblioteca.biblioteca.mappers.AreaTematicaMapper;
import co.com.softka.biblioteca.biblioteca.repositories.RepositoryAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAreaTematicaCRUD {
    @Autowired
    RepositoryAreaTematica repositoryAreaTematica;
    AreaTematicaMapper mapper = new AreaTematicaMapper();

    public List<AreaTematicaDTO> obtenerTodos(){
        List<AreaTematica> area = (List<AreaTematica>)repositoryAreaTematica.findAll();
        return mapper.fromCollectionList(area);
    }

    public AreaTematicaDTO obtenerPorId(String id){
        AreaTematica area = repositoryAreaTematica.findById(id).orElseThrow(() -> new RuntimeException("Area no encontrado"));
        return mapper.fromCollection(area);
    }

    public AreaTematicaDTO crear(AreaTematicaDTO areaDTO) {
        AreaTematica area = mapper.fromDTO(areaDTO);
        return mapper.fromCollection(repositoryAreaTematica.save(area));
    }
    public AreaTematicaDTO modificar(AreaTematicaDTO areaDTO) {
        AreaTematica area = mapper.fromDTO(areaDTO);
        repositoryAreaTematica.findById(area.getId()).orElseThrow(() -> new RuntimeException("area no encontrado"));
        return mapper.fromCollection(repositoryAreaTematica.save(area));
    }
    public void borrar(String id) {
        repositoryAreaTematica.deleteById(id);
    }
}
