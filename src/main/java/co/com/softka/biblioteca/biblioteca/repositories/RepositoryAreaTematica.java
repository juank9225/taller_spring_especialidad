package co.com.softka.biblioteca.biblioteca.repositories;

import co.com.softka.biblioteca.biblioteca.collections.AreaTematica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAreaTematica extends MongoRepository<AreaTematica,String> {

}
