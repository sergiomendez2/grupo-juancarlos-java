package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Salon {
    private int id;
    private int capacidad;
    private String nombre;
    public static List<Salon> listaSalones = new ArrayList<>();
}
