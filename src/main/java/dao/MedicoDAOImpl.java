package dao;

import entidades.Medico;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MedicoDAOImpl implements MedicoDAO {
    private static MedicoDAOImpl instance;
    private Map<Integer, Medico> medicos = new HashMap<>();

    private MedicoDAOImpl() {
        // constructor privado para prevenir instanciación
    }

    public static MedicoDAOImpl getInstance() {
        if (instance == null) {
            instance = new MedicoDAOImpl();
        }
        return instance;
    }

    @Override
    public Medico get(int dni) {
        return medicos.get(dni);
    }

    @Override
    public List<Medico> getAll() {
        return new ArrayList<>(medicos.values());
    }

    @Override
    public void save(Medico medico) {
        medicos.put(medico.getDni(), medico);
    }

    @Override
    public void update(Medico medico, String[] params) {
        medicos.put(medico.getDni(), medico);
    }

    @Override
    public void delete(Medico medico) {
        medicos.remove(medico.getDni());
    }
}