package dao;

import contenedor.Contenedor;
import entidades.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoDAOImplTest {
    private MedicamentoDAO medicamentoDAO;
    private Contenedor contenedor;
    private Medicamento medicamento;

    @BeforeEach
    public void setUp() {
        contenedor = new Contenedor();
        medicamentoDAO = contenedor.MedicamentosDB;
        medicamento = medicamentoDAO.get(1);
    }

    @Test
    public void testGuardarMedicamento() {
        assertDoesNotThrow(() -> medicamentoDAO.save(medicamento));
    }

    @Test
    public void testObtenerMedicamento() {
        assertNull(medicamentoDAO.get(medicamento.getId()));
    }
}