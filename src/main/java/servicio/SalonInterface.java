package servicio;

import modelo.Salon;

import java.util.List;

public interface SalonInterface {
	public String guardarSalon(Salon salon);
	public String modificarSalon(Salon salon);
	public String eliminarSalonPorId(int id);
	public Salon buscarSalonPorId(int id);
	public List<Salon> salones();
}
