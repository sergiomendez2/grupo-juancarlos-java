package servicio;

import modelo.Carrera;
import modelo.CentroRegional;

import java.util.List;

public interface CentroRegionalInterface {
	public String guardarCentroRegional(CentroRegional centroRegional);
	public String actualizarCentroRegional(CentroRegional centroRegional);
	public String eliminarCentroRegionalPorId(int id);
	public CentroRegional buscarCentroRegionalPorId(int id);
	public String agregarCarreraACentroRegional(Carrera carrera, String nombreCentroRegional);
	public List<Carrera> listarCarrerasPorCentroRegional(int id);
}
