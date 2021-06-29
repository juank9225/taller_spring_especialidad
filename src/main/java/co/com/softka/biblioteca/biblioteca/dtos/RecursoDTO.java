package co.com.softka.biblioteca.biblioteca.dtos;

import java.time.LocalDate;

public class RecursoDTO {
    private String id;
    private String nombre;
    private String tipoRecurso;
    private LocalDate fecha;
    private Boolean disponible;
    private String areaTematicaId;

    public RecursoDTO() {

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
        this.fecha = fecha;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
