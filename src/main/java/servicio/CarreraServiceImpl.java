package servicio;

import modelo.Carrera;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;

public class CarreraServiceImpl implements CarreraInterface {

	@Override
	public String guardarCarrera(Carrera carrera) {

		Carrera carreraGuardada = buscarCarreraPorNombre(carrera.getNombre());

		if (carreraGuardada == null) {
			Carrera.listaCarreras.add(carrera);
			return "Carrera Guardad";
		}else{
			return "Carrera ya existe";
		}
	}

	@Override
	public String eliminarCarreraPorNombre(String nombre) {
		Carrera eliminarCarrera = buscarCarreraPorNombre(nombre);
		if (eliminarCarrera != null) {
			Carrera.listaCarreras.remove(eliminarCarrera);
			return "Carrera Eliminada";
		}else{
			return "Carrera no existe";
		}

	}

	@Override
	public String agregarEstudianteACarreraPorNombre(String nombreCarrera, Estudiante estudiante) {
		Carrera carrera = buscarCarreraPorNombre(nombreCarrera);
		if (carrera != null) {
			 carrera.getEstudiantes().add(estudiante);
			return "Estudiante Agregado";
		}else{
			return "Carrera no existe";
		}
	}

	@Override
	public String agregarProfesorACarreraPorNombre(String nombreCarrera, Profesor profesor) {
		Carrera carrera = buscarCarreraPorNombre(nombreCarrera);
		if (carrera != null) {
			carrera.getProfesores().add(profesor);
			return "Profesor Agregado";
		}else{
			return "Carrera no existe";
		}
	}

	@Override
	public Carrera buscarCarreraPorNombre(String nombre) {
		return Carrera.listaCarreras.stream()
				.filter(c -> c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}

	@Override
	public String agregarCursosACarreraPorNombre(String nombreCarrera, Curso curso) {
		Carrera carrera = buscarCarreraPorNombre(nombreCarrera);
		if (carrera != null) {
			carrera.getCursos().add(curso);
			return "Curso Agregado";
		}else{
			return "Carrera no existe";
		}
	}
}
