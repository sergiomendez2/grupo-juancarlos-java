package servicio;

import modelo.Estudiante;

import java.util.List;

public interface EstudianteInterface {
    public String guardarEstudiante(Estudiante estudiante);
    public String modificarEstudiante(Estudiante estudiante);
    public String eliminarEstudiantePorId(int id);
    public Estudiante buscarEstudiantePorId(int id);
    public List<Estudiante> listarEstudiantes();
}

