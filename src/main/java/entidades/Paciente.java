package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    public void pedirTurno (Clinica clinica, Especialidad especialidad) {

    }

    public void pedirTurnoParticular (Clinica clinica, Especialidad especialidad) {

    }

    public void tomarTurno(Medico medico) {

    }

    public void concurrirFarmacia() {

    }
}
