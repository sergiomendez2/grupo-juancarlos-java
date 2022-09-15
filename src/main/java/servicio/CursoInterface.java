package servicio;

import modelo.Curso;

import java.util.List;

public interface CursoInterface {
	public String guardarCurso(Curso curso);
	public String modificarCurso(Curso curso);
	public String eliminarCursoPorId(int id);
	public Curso buscarCursoPorId(int id);
	public List<Curso> listarCursos();
}
