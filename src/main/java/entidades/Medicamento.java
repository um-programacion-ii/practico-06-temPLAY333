package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Medicamento {
    private String nombre;
    private int cantidad;
    private int id;
}
