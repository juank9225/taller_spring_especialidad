package co.com.softka.biblioteca.biblioteca.repositories;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryRecurso extends MongoRepository<Recurso,String> {

    @Transactional(readOnly = true)
    Optional<List<Recurso>> findByareaTematicaId(String areaTematicaId);

    @Transactional(readOnly = true)
    Optional<List<Recurso>> findBytipoRecurso(String tipo);

    @Transactional(readOnly = true)
    Optional<List<Recurso>> findByareaTematicaIdAndTipoRecurso(String areaTematicaId, String tipoRecurso);

}
