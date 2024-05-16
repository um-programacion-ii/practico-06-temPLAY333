package dao;

import entidades.Medicamento;
import entidades.Medico;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MedicamentoDAOImpl implements MedicamentoDAO {
    private static MedicamentoDAOImpl instance;
    private Map<Integer, Medicamento> medicamentos = new HashMap<>();

    private MedicamentoDAOImpl() {
        // constructor privado para prevenir instanciación
    }

    public static MedicamentoDAOImpl getInstance() {
        if (instance == null) {
            instance = new MedicamentoDAOImpl();
        }
        return instance;
    }

    @Override
    public void resetInstance() {
        instance = null;
    }

    @Override
    public Medicamento get(int id) {
        return medicamentos.get(id);
    }

    @Override
    public List<Medicamento> getAll() {
        return new ArrayList<>(medicamentos.values());
    }

    @Override
    public void save(Medicamento medicamento) {
        DAOUtils.saveIfAbsent(medicamentos, medicamento.getId(), medicamento);
    }

    @Override
    public void update(Medicamento medicamento) {
        medicamentos.put(medicamento.getId(), medicamento);
    }

    @Override
    public void delete(int id) {
        medicamentos.remove(id);
    }
}