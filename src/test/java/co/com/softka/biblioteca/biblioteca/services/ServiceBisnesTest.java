package co.com.softka.biblioteca.biblioteca.services;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import co.com.softka.biblioteca.biblioteca.repositories.RepositoryRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ServiceBisnesTest {

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @Autowired
    private ServiceBisnes serviceBisnes;

    @Test
    public void getDisponibilidad(){

        var recurso1 = new Recurso();
        recurso1.setId("61db30202deddb25ca8010f9");
        recurso1.setNombre("amor en tiempos oscuros");
        recurso1.setTipoRecurso("libro");
        recurso1.setFecha(LocalDate.now());
        recurso1.setDisponible(true);
        recurso1.setAreaTematicaId("51db30202deddb25ca8010f5");

        Mockito.when(repositoryRecurso.findById(any())).thenReturn(java.util.Optional.of(recurso1));
        var resultado = serviceBisnes.disponibilidad("51db30202deddb25ca8010f5");

        Assertions.assertEquals(true, resultado.getDisponible());
        Assertions.assertEquals(null, resultado.getFecha());

    }

    @Test
    public void getRecomendarTipo(){

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
        Mockito.when(repositoryRecurso.findBytipoRecurso("libro")).thenReturn(java.util.Optional.of(lista));

        var resultado = serviceBisnes.recomendarPorTipo("libro");

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.get(0).getTipoRecurso());
        Assertions.assertEquals(recurso2.getNombre(), resultado.get(1).getNombre());

    }
}