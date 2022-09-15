package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Facultad {
    private int id;
    private String nombre;
    private int telefono;

    public static List<Facultad> listaFacultades = new ArrayList<>();
}
