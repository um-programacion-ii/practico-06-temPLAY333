package dao;

import entidades.Paciente;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PacienteDAOImpl implements PacienteDAO {
    private Map<Integer, Paciente> pacientes = new HashMap<>();

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