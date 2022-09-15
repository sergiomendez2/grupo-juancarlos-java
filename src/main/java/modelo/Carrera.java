package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Carrera {
    private int id;
    private String nombre;
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private Profesor coordinador;
    private Facultad facultad;
    public static List<Carrera> listaCarreras = new ArrayList<>();
}
