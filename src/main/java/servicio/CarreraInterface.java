package servicio;

import modelo.Carrera;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;

public interface CarreraInterface {

	public String guardarCarrera(Carrera carrera);
	public String eliminarCarreraPorNombre(String nombre);
	public String agregarEstudianteACarreraPorNombre(String nombreCarrera, Estudiante estudiante);
	public String agregarProfesorACarreraPorNombre(String nombreCarrera, Profesor profesor);
	public Carrera buscarCarreraPorNombre(String nombre);
	public String agregarCursosACarreraPorNombre(String nombreCarrera, Curso curso);
}
