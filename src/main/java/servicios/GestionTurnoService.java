package servicios;

import entidades.*;

public class GestionTurnoService {
    private static GestionTurnoService instancia;
    private Clinica clinica = Clinica.getInstancia();

    private GestionTurnoService() {
        // constructor privado para prevenir instanciación
    }

    public static GestionTurnoService getInstancia() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    public void ingresarPaciente(Paciente paciente) {

    }

    public String mostarMedicos(Especialidad especialidad) {
        return null;
    }

    public String mostrarMedicos(ObraSocial os, Especialidad especialidad) {
        return null;
    }

    public void crearTurno(Paciente paciente, Medico medico) {

    }

    public void finalizarTurno(Paciente paciente) {

    }
}
