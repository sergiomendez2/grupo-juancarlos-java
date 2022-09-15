package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Sementre {
    int id;
    String nombre;
    public static List<Sementre> listaSementres = new ArrayList<>();

    public Sementre(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public void guardarSementre(Sementre sementre){
        listaSementres.add(sementre);
    }
}
