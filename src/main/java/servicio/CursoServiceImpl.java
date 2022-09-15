package servicio;

import modelo.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoServiceImpl implements CursoInterface {

	/**
	 * @param curso
	 * @return
	 */
	@Override
	public String guardarCurso(Curso curso){
		Curso existe = Curso.cursos.stream()
				.filter(c -> c.getNombre().equalsIgnoreCase(curso.getNombre()))
				.findFirst()
				.orElse(null);

		if (existe == null) {
			int id = Curso.cursos.size() + 1;
			curso.setId(id);
			Curso.cursos.add(curso);
			return "Curso guardado";
		}else {
			return "El curso ya existe";
		}
	}

	/**
	 * @param curso
	 * @return
	 */
	@Override
	public String modificarCurso(Curso curso) {
	   Curso modificarCurso = buscarCursoPorId(curso.getId());
	   if (modificarCurso != null) {
		   modificarCurso.setNombre(curso.getNombre());
		   modificarCurso.setHoras(curso.getHoras());
		   modificarCurso.setSementre(curso.getSementre());
		   modificarCurso.setProfesor(curso.getProfesor());
		   return "El curso se modifico correctamente";
		   	   }else {
		   return "El curso no existe";
	   }
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public String eliminarCursoPorId(int id) {
		Curso eliminarCurso = buscarCursoPorId(id);
		if (eliminarCurso != null) {
			Curso.cursos.remove(eliminarCurso);
			return "El curso se elimino correctamente";
		}else {
			return "El curso no existe";
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Curso buscarCursoPorId(int id) {
		Curso buscarCurso = Curso.cursos.stream()
				.filter(c -> c.getId() == id)
				.findFirst()
				.orElse(null);
		return buscarCurso;
	}

	/**
	 * @return
	 */
	@Override
	public List<Curso> listarCursos() {
		try {
			return Curso.cursos;
		}catch (Exception e) {
			return null;
		}
	}
}
