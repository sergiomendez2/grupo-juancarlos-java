package servicio;

import modelo.Facultad;

import java.util.List;

public interface FacultadInterface {
	public String guardarFacultad(Facultad facultad);
	public String modificarFacultad(Facultad facultad);
	public String eliminarFacultadPorId(int id);
	public Facultad buscarFacultadPorId(int id);
	public List<Facultad> listarFacultades();
}
