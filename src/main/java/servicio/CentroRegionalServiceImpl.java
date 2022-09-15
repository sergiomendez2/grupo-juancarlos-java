package servicio;

import modelo.Carrera;
import modelo.CentroRegional;

import java.util.List;

public class CentroRegionalServiceImpl implements CentroRegionalInterface {

	/**
	 * @param centroRegional
	 * @return
	 */
	@Override
	public String guardarCentroRegional(CentroRegional centroRegional) {
		CentroRegional existe = CentroRegional.listaCentrosRegionales.stream()
				.filter(c -> c.getNombre().equalsIgnoreCase(centroRegional.getNombre()))
				.findFirst().orElse(null);

		if (existe == null) {
			int id = CentroRegional.listaCentrosRegionales.size() + 1;
			centroRegional.setId(id);
			CentroRegional.listaCentrosRegionales.add(centroRegional);
			return "Centro Regional guardado";
		}else {
			return "El centro regional ya existe";
		}
	}

	/**
	 * @param centroRegional
	 * @return
	 */
	@Override
	public String actualizarCentroRegional(CentroRegional centroRegional) {
		CentroRegional modificarCentroRegional = buscarCentroRegionalPorId(centroRegional.getId());
		if (modificarCentroRegional != null) {
			modificarCentroRegional.setNombre(centroRegional.getNombre());
			modificarCentroRegional.setDireccion(centroRegional.getDireccion());
			return "El centro regional se modifico correctamente";
		}else {
			return "El centro regional no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public String eliminarCentroRegionalPorId(int id) {
		CentroRegional eliminarCentroRegional = buscarCentroRegionalPorId(id);
		if (eliminarCentroRegional != null) {
			CentroRegional.listaCentrosRegionales.remove(eliminarCentroRegional);
			return "El centro regional se elimino correctamente";
		}else {
			return "El centro regional no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public CentroRegional buscarCentroRegionalPorId(int id) {
		CentroRegional centroRegional = CentroRegional.listaCentrosRegionales.stream()
				.filter(c -> c.getId() == id)
				.findFirst().orElse(null);
		return centroRegional;
	}

	/**
	 * @param carrera
	 * @param nombreCentroRegional
	 * @return
	 */
	@Override
	public String agregarCarreraACentroRegional(Carrera carrera, String nombreCentroRegional) {
		CentroRegional centroRegional = CentroRegional.listaCentrosRegionales.stream()
				.filter(c -> c.getNombre().equalsIgnoreCase(nombreCentroRegional))
				.findFirst().orElse(null);

		if (centroRegional != null) {
			centroRegional.getCarreras().add(carrera);
			return "La carrera se agrego correctamente";
		}else {
			return "El centro regional no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public List<Carrera> listarCarrerasPorCentroRegional(int id) {
		CentroRegional centroRegional = buscarCentroRegionalPorId(id);
		if (centroRegional != null) {
			return centroRegional.getCarreras();
		}else {
			return null;
		}
	}
}
