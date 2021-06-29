package co.com.softka.biblioteca.biblioteca.repositories;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRecurso extends MongoRepository<Recurso,String> {

}
