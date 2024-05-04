package entidades;

import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.TurnoDAO;
import dao.TurnoDAOImpl;
import lombok.Getter;
import lombok.Setter;
import servicios.GestionTurnoService;

@Getter
@Setter
public class Clinica {
    private static Clinica instancia;
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;
    private TurnoDAO turnoDAO;

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
