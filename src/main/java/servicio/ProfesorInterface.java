package servicio;


import modelo.Profesor;

import java.util.List;

public interface ProfesorInterface {
	public String guardarProfesor(Profesor profesor);
	public String modificarprofesor(Profesor profesor);
	public String eliminarProfesorPorId(int id);
	public Profesor buscarProfesorPorId(int id);
	public List<Profesor> listarProfesores();
}
