package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CentroRegional {
    private int id;
    private String nombre;
    private String direccion;
    private List<Carrera> carreras;
    public static List<CentroRegional> listaCentrosRegionales = new ArrayList<>();
}
