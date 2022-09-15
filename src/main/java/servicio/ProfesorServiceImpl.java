package servicio;

import modelo.Profesor;

import java.awt.color.ProfileDataException;
import java.util.List;
import java.util.stream.Collectors;

public class ProfesorServiceImpl implements ProfesorInterface {

	/**
	 * @param profesor
	 * @return
	 */
	@Override
	public String guardarProfesor(Profesor profesor) {
		Profesor existe = Profesor.listaProfesores
				.stream()
				.filter(p -> p.getDpi() == profesor.getDpi())
				.findFirst()
				.orElse(null);

		if (existe == null) {
			int id = Profesor.listaProfesores.size() + 1;
			profesor.setId(id);
			Profesor.listaProfesores.add(profesor);
			return "Profesor guardado";
		}else {
			return "El profesor ya existe";
		}
	}

	/**
	 * @param profesor
	 * @return
	 */
	@Override
	public String modificarprofesor(Profesor profesor) {
		Profesor modificarProfesor = buscarProfesorPorId(profesor.getId());
		if (modificarProfesor != null) {
			modificarProfesor.setNombre(profesor.getNombre());
			modificarProfesor.setApellido(profesor.getApellido());
			modificarProfesor.setDpi(profesor.getDpi());
			modificarProfesor.setDireccion(profesor.getDireccion());
			modificarProfesor.setTelefono(profesor.getTelefono());
			modificarProfesor.setCorreo(profesor.getCorreo());
			modificarProfesor.setFechaNacimiento(profesor.getFechaNacimiento());
			return "El profesor se modifico correctamente";
		}else {
			return "El profesor no existe";
		}

	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public String eliminarProfesorPorId(int id) {
		Profesor eliminarProfesor = buscarProfesorPorId(id);
		if (eliminarProfesor != null) {
			Profesor.listaProfesores.remove(eliminarProfesor);
			return "El profesor se elimino correctamente";
		}else {
			return "El profesor no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Profesor buscarProfesorPorId(int id) {
		Profesor encontrarProfesor = Profesor.listaProfesores.stream()
				.filter(prof -> prof.getId() == id)
				.findFirst()
				.orElse(null);
		return null;
	}

	/**
	 * @return
	 */
	@Override
	public List<Profesor> listarProfesores() {
		try {
		return Profesor.listaProfesores.stream().filter(prof -> prof.
		getEstado() =="activo").collect(Collectors.toList());
		}catch (Exception e) {
			System.out.println("Error al listar los profesores");
			return null;
		}
	}
}
