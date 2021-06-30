package co.com.softka.biblioteca.biblioteca.services;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
import co.com.softka.biblioteca.biblioteca.repositories.RepositoryRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;


@SpringBootTest
@AutoConfigureMockMvc
class ServiceRecursoCRUDTest {

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @Autowired
    private ServiceRecursoCRUD serviceRecursoCRUD;

    @Test
    @DisplayName("Test findAll Success")
    public void obtenerTodos(){
        var recurso1 = new Recurso();
        recurso1.setId("61db30202deddb25ca8010f9");
        recurso1.setNombre("amor en tiempos oscuros");
        recurso1.setTipoRecurso("libro");
        recurso1.setFecha(LocalDate.now());
        recurso1.setDisponible(true);
        recurso1.setAreaTematicaId("51db30202deddb25ca8010f5");

        var recurso2 = new Recurso();
        recurso2.setId("61db30202deddb25ca8010f9");
        recurso2.setNombre("amor en tiempos oscuros");
        recurso2.setTipoRecurso("libro");
        recurso2.setFecha(LocalDate.now());
        recurso2.setDisponible(true);
        recurso2.setAreaTematicaId("51db30202deddb25ca8010f5");

        var lista = new ArrayList<Recurso>();
        lista.add(recurso1);
        lista.add(recurso2);
        Mockito.when(repositoryRecurso.findAll()).thenReturn(lista);

        var resultado = serviceRecursoCRUD.obtenerTodos();

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(recurso1.getNombre(), resultado.get(0).getNombre());
        Assertions.assertEquals(recurso2.getNombre(), resultado.get(1).getNombre());
    }

    @Test
    @DisplayName("Test save Success")
    public void crear(){
        var recurso1 = new Recurso();
        recurso1.setId("61db30202deddb25ca8010f9");
        recurso1.setNombre("amor en tiempos oscuros");
        recurso1.setTipoRecurso("libro");
        recurso1.setFecha(LocalDate.now());
        recurso1.setDisponible(true);
        recurso1.setAreaTematicaId("51db30202deddb25ca8010f5");

        var recurso2 = new RecursoDTO();
        recurso2.setId("61db30202deddb25ca8010f9");
        recurso2.setNombre("amor en tiempos oscuros");
        recurso2.setTipoRecurso("libro");
        recurso2.setFecha(LocalDate.now());
        recurso2.setDisponible(true);
        recurso2.setAreaTematicaId("51db30202deddb25ca8010f5");

        Mockito.when(repositoryRecurso.save(any())).thenReturn(recurso1);

        var resultado = serviceRecursoCRUD.crear(recurso2);

        Assertions.assertNotNull(resultado, "el valor guardado no debe ser nulo");

        Assertions.assertEquals(recurso1.getNombre(), resultado.getNombre(), "el nombre no corresponde");
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.getTipoRecurso(), "el tipo no corresponde");

    }

}