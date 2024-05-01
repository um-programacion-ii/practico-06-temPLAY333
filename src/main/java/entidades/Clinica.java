package entidades;

import dao.MedicoDAO;
import dao.PacienteDAO;
import lombok.Getter;
import lombok.Setter;
import servicios.GestionTurnoService;

@Getter
@Setter
public class Clinica {
    private static Clinica instancia;
    private GestionTurnoService gestionTurnoService = GestionTurnoService.getInstancia();
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;

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
