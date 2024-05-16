package servicios;

import contenedor.Contenedor;
import entidades.Medicamento;
import entidades.Paciente;
import entidades.Receta;
import excepciones.CantidadInsuficienteException;
import excepciones.EntidadNullException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionFarmaciaServiceTest {
    private GestionFarmaciaService gestionFarmaciaService;
    private Paciente paciente;
    private Contenedor contenedor;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = GestionFarmaciaService.getInstancia();
        contenedor = new Contenedor();
        contenedor.init();
        paciente = contenedor.PacientesDB.get(4);
    }

    @AfterEach
    public void tearDown() {
        contenedor.reset();
        contenedor = null;
    }

    @Test
    public void testTenerReceta() {;
        try {
            assertTrue(gestionFarmaciaService.tenerReceta(paciente));
        } catch (EntidadNullException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testNoTenerReceta() {
        paciente.setReceta(null);
        assertThrows(EntidadNullException.class, () -> gestionFarmaciaService.tenerReceta(paciente));
    }

    @Test
    public void testDarMedicamentos() {
        Medicamento medicamento = new Medicamento("Medicamento", 10, 1);
        paciente.getReceta().getMedicamentos().set(0, medicamento);
        assertDoesNotThrow(() -> gestionFarmaciaService.darMedicamentos(paciente));
    }

    @Test
    public void testDarMedicamentosCantidadInsuficiente() {
        Medicamento medicamento = new Medicamento("Medicamento", 1000, 1);
        paciente.getReceta().getMedicamentos().set(0, medicamento);
        assertThrows(CantidadInsuficienteException.class, () -> gestionFarmaciaService.darMedicamentos(paciente));
    }

    @Test
    public void testPedidoADrogueria() {
        List<Medicamento> medicamentos = new ArrayList<>();
        Medicamento medicamento = new Medicamento("Medicamento", 0, 1);
        medicamentos.add(medicamento);
        gestionFarmaciaService.pedidoADrogueria(medicamentos);
        assertEquals(100, medicamento.getCantidad());
    }

    @Test
    public void testAgregarMedicamento() {
        assertDoesNotThrow(() -> gestionFarmaciaService.agregarMedicamento("Nuevo medicamento"));
        Medicamento medicamento = contenedor.MedicamentosDB.get(10);
        assertNotNull(medicamento);
        assertEquals("Nuevo medicamento", medicamento.getNombre());
    }
}