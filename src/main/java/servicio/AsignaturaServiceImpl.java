package servicio;

import modelo.Asignatura;
import modelo.Estudiante;

import java.util.List;
import java.util.stream.Collectors;

public class AsignaturaServiceImpl implements AsignaturaInterface {

	/**
	 * @param asignatura
	 * @return
	 */
	@Override
	public String guardarAsignatura(Asignatura asignatura) {
		int id = Asignatura.listaAsignaturas.size() + 1;
		asignatura.setId(id);
		Asignatura.listaAsignaturas.add(asignatura);
		return "Asignatura guardada";
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public String eliminarAsignaturaPorId(int id) {
		Asignatura eliminarAsignatura = buscarAsignaturaPorId(id);
		if (eliminarAsignatura != null) {
			Asignatura.listaAsignaturas.remove(eliminarAsignatura);
			return "La asignatura se elimino correctamente";
		}else {
			return "La asignatura no existe";
		}
	}

	/**
	 * @param asignatura
	 * @return
	 */
	@Override
	public String modificarAsignatura(Asignatura asignatura) {
		Asignatura modificarAsignatura = buscarAsignaturaPorId(asignatura.getId());
		if (modificarAsignatura != null) {
			modificarAsignatura.setEstudiante(asignatura.getEstudiante());
			modificarAsignatura.setSementre(asignatura.getSementre());
			modificarAsignatura.setCarrera(asignatura.getCarrera());
			modificarAsignatura.setSalon(asignatura.getSalon());
			return "La asignatura se modifico correctamente";
		}else {
			return "La asignatura no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Asignatura buscarAsignaturaPorId(int id) {
		return Asignatura.listaAsignaturas.stream()
				.filter(asignatura -> asignatura.getId() == id)
				.findFirst()
				.orElse(null);
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public List<Estudiante> buscarAsignaturaPorIdEstudiante(int id) {
		try {
			return Asignatura.listaAsignaturas.stream()
					.filter(asignatura -> asignatura.getEstudiante().getId() ==id)
					.map(asignatura -> asignatura.getEstudiante())
					.collect(Collectors.toList());
		} catch (Exception e) {
			return null;
		}
	}
}
