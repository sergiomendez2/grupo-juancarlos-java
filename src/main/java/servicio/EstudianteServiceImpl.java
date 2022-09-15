package servicio;

import modelo.Estudiante;

import java.util.List;
import java.util.stream.Collectors;

public class EstudianteServiceImpl implements EstudianteInterface {


    /**
     * @param estudiante
     * @return 
     */
    @Override
    public String guardarEstudiante(Estudiante estudiante) {
        Estudiante encontrarEstudiante = Estudiante.listaEstudiantes.stream()
                        .filter(estu -> estu.getDpi() == estudiante.getDpi())
                        .findFirst()
                        .orElse(null);

        if (encontrarEstudiante == null) {
            int id = Estudiante.listaEstudiantes.size() + 1;
            estudiante.setId(id);
            Estudiante.listaEstudiantes.add(estudiante);
            return "Estudiante guardado";
        }else{
            return "El estudiante ya existe";
        }

    }

    /**
     * @param estudiante
     * @return 
     */
    @Override
    public String modificarEstudiante(Estudiante estudiante) {
         Estudiante modificarEstudiante = buscarEstudiantePorId(estudiante.getId());
         if (modificarEstudiante != null) {
                modificarEstudiante.setNombre(estudiante.getNombre());
                modificarEstudiante.setApellido(estudiante.getApellido());
                modificarEstudiante.setDpi(estudiante.getDpi());
                modificarEstudiante.setDireccion(estudiante.getDireccion());
                modificarEstudiante.setTelefono(estudiante.getTelefono());
                modificarEstudiante.setCorreo(estudiante.getCorreo());
                modificarEstudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
                return "El estudiantes se modifico correctamente";
         }else{
               return "El estudiante no existe";
         }

    }

    /**
     * @param id
     * @return 
     */
    @Override
    public String eliminarEstudiantePorId(int id) {
        Estudiante eliminarEstudiante = buscarEstudiantePorId(id);
        if (eliminarEstudiante != null) {
            Estudiante.listaEstudiantes.remove(eliminarEstudiante);
            return "El estudiante se elimino correctamente";
        }else{
            return "El estudiante no existe";
        }

    }

    /**
     * @param id
     * @return
     */
    @Override
    public Estudiante buscarEstudiantePorId(int id) {
        Estudiante encontrarEstudiante = Estudiante.listaEstudiantes.stream()
                        .filter(estu -> estu.getId() == id)
                        .findFirst()
                        .orElse(null);
        return encontrarEstudiante;
    }

    /**
     * @return
     */
    @Override
    public List<Estudiante> listarEstudiantes() {
      try {
          return Estudiante
                  .listaEstudiantes.stream()
                  .filter(estudiante -> estudiante.getEstado().equalsIgnoreCase("activo"))
                  .collect(Collectors.toList());
      }catch (Exception e){
          System.out.println("lista vacia");
          return null;
      }
    }
}

