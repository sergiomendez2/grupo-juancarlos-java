package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Curso {
    private int id;
    private String nombre;
    int horas;
    private Sementre sementre;
    private Profesor profesor;
    public static List<Curso> cursos = new ArrayList<>();
}
