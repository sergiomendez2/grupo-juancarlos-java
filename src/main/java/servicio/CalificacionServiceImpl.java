package servicio;

import modelo.Calificacion;
import modelo.Curso;
import modelo.Estudiante;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Carrera;

public class CalificacionServiceImpl implements CalificacionInterface {


	/**
	 * @param estudiante
	 * @param nota
	 * @param curso
	 * @param comentario
	 * @return
	 */
	@Override
	public String guardarCalificacion(Estudiante estudiante, int nota, Curso curso, String comentario) {
		//get the date of the computer
		Date date = new Date();
		Calificacion nuevaCalificacion = new Calificacion();
		nuevaCalificacion.setEstudiante(estudiante);
		nuevaCalificacion.setCurso(curso);
		nuevaCalificacion.setNota(nota);
		nuevaCalificacion.setComentario(comentario);
		nuevaCalificacion.setFechaIngreso(date);
		return "Calificacion guardada!";
	}

	/**
     * @param idCalificacion
	 * @param nota
     * @param carrera
	 * @param curso
	 * @param comentario
	 * @return
	 */
	@Override
	public String modificarNotaEstudiante(int idCalificacion, int nota,Carrera carrera ,Curso curso, String comentario) {
		Calificacion modificarNotaEstudiante = Calificacion.listaCalificaciones.stream()
				.filter(c -> c.getId() == idCalificacion).findFirst().orElse(null);

		Calificacion cursoModificarNotaEstudiante = Calificacion.listaCalificaciones.stream()
				.filter(cu -> cu.getCurso().getNombre().equalsIgnoreCase(curso.getNombre())).findFirst().orElse(null);

		Date fechaModificacion =new Date();
		if (modificarNotaEstudiante != null && cursoModificarNotaEstudiante != null) {
			modificarNotaEstudiante.setNota(nota);
			modificarNotaEstudiante.setComentario(comentario);
			modificarNotaEstudiante.setFechaIngreso(fechaModificacion);
                        modificarNotaEstudiante.setCarrera(carrera);
			return "Nota del estudiante:  "+ modificarNotaEstudiante.getEstudiante().getNombre()+ " modificado Correctamente";
		}else{
			return "Calificacion no se puedo modificar";
		}

	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public List<Calificacion> listarCalificacionesPorEstudiante(int id) {
		try {
			return Calificacion.listaCalificaciones
					.stream()
					.filter(calificacion -> calificacion.getEstudiante().getId() == id)
					.collect(Collectors.toList());
		} catch (Exception e) {
			return null;
		}
	}
}
