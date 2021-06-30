package co.com.softka.biblioteca.biblioteca.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private String tipoRecurso;
    private LocalDate fecha;
    private Boolean disponible;
    private String areaTematicaId;

    public Recurso() {
    }

    public Recurso(String id, String nombre, String tipoRecurso, LocalDate fecha, Boolean disponible, String areaTematicaId) {
        this.id = id;
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
        this.fecha = fecha;
        this.disponible = disponible;
        this.areaTematicaId = areaTematicaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaTematicaId() {
        return areaTematicaId;
    }

    public void setAreaTematicaId(String areaTematicaId) {
        this.areaTematicaId = areaTematicaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = LocalDate.now();
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
