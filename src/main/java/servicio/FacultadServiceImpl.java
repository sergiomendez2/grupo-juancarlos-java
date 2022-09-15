package servicio;

import modelo.Facultad;

import java.util.List;

public class FacultadServiceImpl implements FacultadInterface {


	/**
	 * @param facultad
	 * @return
	 */
	@Override
	public String guardarFacultad(Facultad facultad) {
		Facultad existeFacultad = Facultad.listaFacultades.stream()
				.filter(f -> f.getNombre().equalsIgnoreCase(facultad.getNombre()))
				.findFirst()
				.orElse(null);
		if(existeFacultad == null) {
			int id = Facultad.listaFacultades.size() + 1;
			facultad.setId(id);
			Facultad.listaFacultades.add(facultad);
			return "registro guardado!";
		}else {
			return "registro ya existe";
		}
	}

	/**
	 * @param facultad
	 * @return
	 */
	@Override
	public String modificarFacultad(Facultad facultad) {
		Facultad modificarFacultad = buscarFacultadPorId(facultad.getId());
		if(modificarFacultad != null) {
			modificarFacultad.setNombre(facultad.getNombre());
			return "registro modificado";
		}else {
			return "registro no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public String eliminarFacultadPorId(int id) {
		Facultad eliminarFacultad = buscarFacultadPorId(id);
		if (eliminarFacultad != null) {
			Facultad.listaFacultades.remove(eliminarFacultad);
			return "Facultad eliminada";
		} else {
			return "No se encontró la facultad";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Facultad buscarFacultadPorId(int id) {
	      Facultad facultad = Facultad.listaFacultades
			      .stream()
			      .filter(f -> f.getId() == id)
			      .findFirst().orElse(null);
		  return facultad;
	}

	/**
	 * @return
	 */
	@Override
	public List<Facultad> listarFacultades() {
		try {
			return Facultad.listaFacultades;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
