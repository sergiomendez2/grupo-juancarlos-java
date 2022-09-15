package servicio;

import modelo.Asignatura;
import modelo.Estudiante;

import java.util.List;

public interface AsignaturaInterface {
	public String guardarAsignatura(Asignatura asignatura);
	public String eliminarAsignaturaPorId(int  id);
	public String modificarAsignatura(Asignatura asignatura);
	public Asignatura buscarAsignaturaPorId(int id);
	public List<Estudiante> buscarAsignaturaPorIdEstudiante(int id);

}
