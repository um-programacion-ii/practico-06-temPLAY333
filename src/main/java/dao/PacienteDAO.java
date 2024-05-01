package dao;

import entidades.Paciente;
import servicios.AtencionMedicoService;

import java.util.HashMap;
import java.util.Map;

public class PacienteDAO {
    private static PacienteDAO instancia;
    private final Map<Integer, Paciente> pacientes;

    private PacienteDAO() {
        pacientes = new HashMap<>();
    }

    public static PacienteDAO getInstancia() {
        if (instancia == null) {
            instancia = new PacienteDAO();
        }
        return instancia;
    }

    public void guardarPaciente(Paciente paciente) {
        pacientes.put(paciente.getDni(), paciente);
    }

    public Paciente obtenerPaciente(Integer id) {
        return pacientes.get(id);
    }

    public void eliminarPaciente(Integer id) {
        pacientes.remove(id);
    }
}
