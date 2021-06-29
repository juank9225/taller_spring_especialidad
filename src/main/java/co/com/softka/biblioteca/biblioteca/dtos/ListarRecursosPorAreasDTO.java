package co.com.softka.biblioteca.biblioteca.dtos;

import co.com.softka.biblioteca.biblioteca.collections.Recurso;

import java.util.List;

public class ListarRecursosPorAreasDTO {
    private String area;
    private List<Recurso> recursos;

    public ListarRecursosPorAreasDTO() {

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
}
