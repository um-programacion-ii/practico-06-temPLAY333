package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import servicios.GestionTurnoService;

@Getter
@Setter
@AllArgsConstructor
public class Paciente {
    private String nombre;
    private String apellido;
    private int dni;
    private ObraSocial os;
    private Turno turno = null;
    private Receta receta = null;
}
