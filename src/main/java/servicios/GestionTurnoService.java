package servicios;

import entidades.*;
import excepciones.EntidadNotNullException;
import excepciones.EntidadNullException;

import java.util.ArrayList;
import java.util.List;

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
        clinica.getPacienteDAO().save(paciente);
    }

    public List<Medico> mostrarMedicos(Especialidad especialidad) {
        List<Medico> medicos = clinica.getMedicoDAO().getAll();
        List<Medico> especialistas = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.getEspecialidad() == especialidad) {
                especialistas.add(medico);
            }
        }
        return especialistas;
    }

    public List<Medico> mostrarMedicos(ObraSocial os, Especialidad especialidad) {
        List<Medico> especialistas = this.mostrarMedicos(especialidad);
        List<Medico> medicOS = new ArrayList<>();
        for (Medico medico : especialistas) {
            if (medico.getOs().contains(os)) {
                medicOS.add(medico);
            }
        }
        return medicOS;
    }

    public void crearTurno(Paciente paciente, Medico medico) throws EntidadNotNullException {
        Turno turno = medico.disponibilidad();
        if (paciente.getTurno() == null) {
            paciente.setTurno(turno);
            clinica.getPacienteDAO().update(paciente);
        } else {
            throw new EntidadNotNullException("Paciente con Turno");
        }
    }

    public void finalizarTurno(Paciente paciente) throws EntidadNullException {
        if (paciente.getTurno() != null) {
            paciente.setTurno(null);
            clinica.getPacienteDAO().update(paciente);
        } else {
            throw new EntidadNullException("Paciente sin Turno");
        }
    }
}
