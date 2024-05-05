package entidades;

import dao.*;
import lombok.Getter;
import lombok.Setter;
import servicios.GestionTurnoService;

@Getter
@Setter
public class Clinica {
    private static Clinica instancia;
    private PacienteDAO pacienteDAO = PacienteDAOImpl.getInstance();
    private MedicoDAO medicoDAO = MedicoDAOImpl.getInstance();
    private TurnoDAO turnoDAO = TurnoDAOImpl.getInstance();

    private Clinica() {
        // constructor privado para prevenir instanciación
    }

    public static Clinica getInstancia() {
        if (instancia == null) {
            instancia = new Clinica();
        }
        return instancia;
    }


}
