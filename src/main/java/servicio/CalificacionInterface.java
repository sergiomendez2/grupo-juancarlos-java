package servicio;

import modelo.Calificacion;
import modelo.Curso;
import modelo.Estudiante;

import java.util.List;
import modelo.Carrera;

public interface CalificacionInterface {
	public String guardarCalificacion(Estudiante estudiante, int nota, Curso curso, String comentario);
	public String modificarNotaEstudiante(int idCalificacion, int nota, Carrera carrera,Curso curso, String comentario);
	List<Calificacion> listarCalificacionesPorEstudiante(int id);

}
