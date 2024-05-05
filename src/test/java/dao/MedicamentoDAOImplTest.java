package dao;

import contenedor.Contenedor;
import entidades.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void testObtenerMedicamento() {
        assertEquals(medicamento, medicamentoDAO.get(medicamento.getId()));
    }

    @Test
    public void testObtenerTodos() {
        List<Medicamento> medicamentos = medicamentoDAO.getAll();
        assertTrue(medicamentos.contains(medicamento));
        assertTrue(medicamentos.contains(medicamentoDAO.get(2)));
    }

    @Test
    public void testGuardarMedicamento() {
        assertDoesNotThrow(() -> medicamentoDAO.save(medicamento));
    }

    @Test
    public void testGuardarYObtenerMedicamento() {
        Medicamento nuevoMedicamento = new Medicamento("Nuevo medicamento",10, 10);
        medicamentoDAO.save(nuevoMedicamento);
        assertEquals(nuevoMedicamento, medicamentoDAO.get(10));
    }

    @Test
    public void testGuardarMedicamentoConIdExistente() {
        Medicamento medicamentoNuevo = new Medicamento("Medicamento nuevo", 20, 1);
        medicamentoDAO.save(medicamentoNuevo);
        Medicamento medicamentoGuardado = medicamentoDAO.get(1);
        assertEquals(medicamento, medicamentoGuardado);
        assertNotEquals(medicamentoNuevo, medicamentoGuardado);
    }

    @Test
    public void testModificarYActualizarMedicamento() {
        medicamento.setNombre("Nuevo nombre");
        medicamentoDAO.update(medicamento, null);
        Medicamento medicamentoModificado = medicamentoDAO.get(medicamento.getId());
        assertEquals("Nuevo nombre", medicamentoModificado.getNombre());
    }

    @Test
    public void testEliminar() {
        medicamentoDAO.delete(medicamento);
        assertNull(medicamentoDAO.get(medicamento.getId()));
    }
}