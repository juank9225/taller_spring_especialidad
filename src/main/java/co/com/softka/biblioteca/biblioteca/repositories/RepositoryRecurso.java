package co.com.softka.biblioteca.biblioteca.repositories;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryRecurso extends MongoRepository<Recurso,String> {

}
