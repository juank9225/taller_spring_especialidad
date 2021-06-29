package co.com.softka.biblioteca.biblioteca.dtos;

import java.time.LocalDate;
import java.util.Date;

public class RespuestaDTO {
    private String respuesta;
    private Boolean disponible;
    private LocalDate fecha;

    public RespuestaDTO() {

    }

    public RespuestaDTO(String respuesta, Boolean disponible, LocalDate fecha) {
        this.respuesta = respuesta;
        this.disponible = disponible;
        this.fecha = fecha;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
