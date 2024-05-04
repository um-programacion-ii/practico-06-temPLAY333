package servicios;

import entidades.Medico;
import entidades.Paciente;

public class AtencionMedicoService {
    private static AtencionMedicoService instancia;

    private AtencionMedicoService() {
        // constructor privado para prevenir instanciación
    }

    public static AtencionMedicoService getInstancia() {
        if (instancia == null) {
            instancia = new AtencionMedicoService();
        }
        return instancia;
    }

    public boolean tenerTurno (Paciente paciente){
        return true;
    }

    public Object atenderPaciente (Medico medico, Paciente paciente) {
        return null;
    }
}

