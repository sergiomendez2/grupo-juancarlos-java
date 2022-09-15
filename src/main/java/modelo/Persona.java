package modelo;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
abstract class Persona {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int dpi;
    protected Date fechaNacimiento;
    protected String genero;
    protected String direccion;
    protected int telefono;
    protected String correo;
    protected String estado;

}
