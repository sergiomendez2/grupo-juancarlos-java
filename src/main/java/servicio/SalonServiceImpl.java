package servicio;

import modelo.Salon;

import java.util.List;

public class SalonServiceImpl implements SalonInterface{
	/**
	 * @param salon
	 * @return
	 */
	@Override
	public String guardarSalon(Salon salon) {
		Salon existe = Salon.listaSalones.stream().filter(sal->sal.getNombre().equalsIgnoreCase(salon.getNombre()))
				.findFirst().orElse(null);

		if(existe ==null) {
			int id = Salon.listaSalones.size() + 1;
			Salon.listaSalones.add(salon);
			return "registro guardado!";
		}else{
			return "registro ya existe";
		}
	}

	/**
	 * @param salon
	 * @return
	 */
	@Override
	public String modificarSalon(Salon salon) {
		Salon modificarSalon = buscarSalonPorId(salon.getId());
		if(modificarSalon != null) {
			modificarSalon.setNombre(salon.getNombre());
			modificarSalon.setCapacidad(salon.getCapacidad());
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
	public String eliminarSalonPorId(int id) {
		Salon eliminarSalon = buscarSalonPorId(id);
		if(eliminarSalon != null) {
			Salon.listaSalones.remove(eliminarSalon);
			return "registro eliminado";
		}else {
			return "registro no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Salon buscarSalonPorId(int id) {
		Salon buscarSalon = Salon.listaSalones.stream().filter(sal->sal.getId() == id)
				.findFirst().orElse(null);
		return buscarSalon;
	}

	/**
	 * @return
	 */
	@Override
	public List<Salon> salones() {
		try {
			return Salon.listaSalones;
		}catch (Exception e){
			return null;
		}
	}
}
