package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paciente {
    private String nombre;
    private String apellido;
    private int id;
    private ObraSocial os;
    private Turno turno = null;
    private Receta receta = null;
}
