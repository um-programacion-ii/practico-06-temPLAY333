package dao;

import entidades.Medico;
import java.util.HashMap;
import java.util.Map;

public class MedicoDAO {
    private Map<String, Medico> medicos;

    public MedicoDAO() {
        medicos = new HashMap<>();
    }

    public void guardarMedico(String id, Medico medico) {
        medicos.put(id, medico);
    }

    public Medico obtenerMedico(String id) {
        return medicos.get(id);
    }

    public void eliminarMedico(String id) {
        medicos.remove(id);
    }
}