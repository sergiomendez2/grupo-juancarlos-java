package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Asignatura {
    private int id;
    private Estudiante estudiante;
    private Carrera carrera;
    private Sementre sementre;
    private Salon salon;
    private Curso curso;
    public static List<Asignatura> listaAsignaturas = new ArrayList<>();
}
