package dao;

import entidades.Paciente;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PacienteDAOImpl implements PacienteDAO {
    private static PacienteDAOImpl instance;
    private Map<Integer, Paciente> pacientes = new HashMap<>();

    private PacienteDAOImpl() {
        // constructor privado para prevenir instanciación
    }

    public static PacienteDAOImpl getInstance() {
        if (instance == null) {
            instance = new PacienteDAOImpl();
        }
        return instance;
    }

    @Override
    public Paciente get(int dni) {
        return pacientes.get(dni);
    }

    @Override
    public List<Paciente> getAll() {
        return new ArrayList<>(pacientes.values());
    }

    @Override
    public void save(Paciente paciente) {
        pacientes.put(paciente.getDni(), paciente);
    }

    @Override
    public void update(Paciente paciente, String[] params) {
        pacientes.put(paciente.getDni(), paciente);
    }

    @Override
    public void delete(Paciente paciente) {
        pacientes.remove(paciente.getDni());
    }
}