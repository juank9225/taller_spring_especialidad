package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
import co.com.softka.biblioteca.biblioteca.services.ServiceRecursoCRUD;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpHeaders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerRecursoTest {

    @MockBean
    private ServiceRecursoCRUD serviceRecursoCRUD;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRecursos() throws Exception{
        //Arrange
        var recurso1 = new RecursoDTO();
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

        doReturn(Lists.newArrayList(recurso1,recurso2)).when(serviceRecursoCRUD).obtenerTodos(); //creamos el mock

        //Act && Assert
        mockMvc.perform(get("/recurso"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(header().string(HttpHeaders.LOCATION,"/recurso"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void postRecurso() throws Exception{
        //Arrange
        var recursoPost = new RecursoDTO();
            recursoPost.setId("61db30202deddb25ca8010f9");
            recursoPost.setNombre("amor en tiempos oscuros");
            recursoPost.setTipoRecurso("libro");
            recursoPost.setFecha(LocalDate.now());
            recursoPost.setDisponible(true);
            recursoPost.setAreaTematicaId("51db30202deddb25ca8010f5");

        var recursoReturn = new RecursoDTO();
            recursoReturn.setId("61db30202deddb25ca8010f9");
            recursoReturn.setNombre("amor en tiempos oscuros");
            recursoReturn.setTipoRecurso("libro");
            recursoReturn.setFecha(LocalDate.now());
            recursoReturn.setDisponible(true);
            recursoReturn.setAreaTematicaId("51db30202deddb25ca8010f5");

        Mockito.when(serviceRecursoCRUD.crear(recursoPost)).thenReturn(recursoReturn); //creamos el mock

        //Act && Assert
        mockMvc.perform(post("/crear"))
              //  .contentType(MediaType.APPLICATION_JSON)
               // .content(asJsonString(recursoPost))

                // Validate the response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is("61db30202deddb25ca8010f9")))
                .andExpect(jsonPath("$.nombre", is("amor en tiempos oscuros")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}