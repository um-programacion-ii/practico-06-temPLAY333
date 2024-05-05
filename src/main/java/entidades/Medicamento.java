package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Medicamento {
    private String nombre;
    private int cantidad;
    private int id;
}
