import entidades.*;
import servicios.*;

public class InterfazUsuario {
    private GestionTurnoService TurnoService = GestionTurnoService.getInstancia();
    private GestionFarmaciaService FarmaciaService = GestionFarmaciaService.getInstancia();
    private AtencionMedicoService MedicoService = AtencionMedicoService.getInstancia();

    public void ingresarClinica(Paciente paciente, Clinica clinica){

    }

    public void solicitarTurnoOS(Paciente paciente, Especialidad especialidad) {
        try {
            // TurnoService.crearTurno(paciente, medico);
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, mostrar un mensaje de error al usuario
        }
    } // Lista de medicos que atienden OS y Especialidad

    public void solicitarTurnoParticular(Paciente paciente, Especialidad especialidad) {

    } // Lista de medicos de esa Especialidad

    public void tenerTurno(Paciente paciente, Medico medico){

    }

    public void comprarMedicamentos(Paciente paciente){

    }
}