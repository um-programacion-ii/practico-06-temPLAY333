package dao;

import entidades.Medicamento;
import java.util.HashMap;
import java.util.Map;

public class MedicamentoDAO {
    private Map<String, Medicamento> medicamentos;

    public MedicamentoDAO() {
        medicamentos = new HashMap<>();
    }

    public void guardarMedicamento(String id, Medicamento medicamento) {
        medicamentos.put(id, medicamento);
    }

    public Medicamento obtenerMedicamento(String id) {
        return medicamentos.get(id);
    }

    public void eliminarMedicamento(String id) {
        medicamentos.remove(id);
    }
}
