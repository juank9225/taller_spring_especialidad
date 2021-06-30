package co.com.softka.biblioteca.biblioteca.controllers;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;
import co.com.softka.biblioteca.biblioteca.dtos.RecursoDTO;
import co.com.softka.biblioteca.biblioteca.mappers.RecursoMapper;
import co.com.softka.biblioteca.biblioteca.services.ServiceRecursoCRUD;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.spy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerRecursoTest {

    @MockBean
    private ServiceRecursoCRUD serviceRecursoCRUD;

    @Autowired
    private MockMvc mockMvc;

    RecursoMapper mapper = new RecursoMapper();

    @Test
    public void getRecursos() throws Exception{
        //Arrange
        Recurso recurso1 = new Recurso("61db30202deddb25ca8010f9","amores peligroos","crimen", LocalDate.now(),true,"51db30202deddb25ca8010f5");
        Recurso recurso2 = new Recurso("71db30202deddb24ca8010f2","el principito","cuento", LocalDate.now(),true,"51db30202deddb25ca8010f5");

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
        Recurso recurso1 = new Recurso("61db30202deddb25ca8010f9","amores peligroos","crimen", LocalDate.now(),true,"51db30202deddb25ca8010f5");
        RecursoDTO recursoDTO = mapper.fromCollection(recurso1);

        doReturn(recursoDTO).when(serviceRecursoCRUD).crear(any()); //creamos el mock

        //Act && Assert
        mockMvc.perform(post("/recurso/crear"))
                //.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("61db30202deddb25ca8010f9")))
                .andExpect(jsonPath("$.nombre", is("New Widget")));
    }

}