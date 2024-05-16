package dao;

import contenedor.Contenedor;
import entidades.Medico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoDAOImplTest {
    private MedicoDAO medicoDAO;
    private Contenedor contenedor;
    private Medico medico;

    @BeforeEach
    public void setUp() {
        contenedor = new Contenedor();
        contenedor.init();
        medicoDAO = contenedor.MedicosDB;
        medico = medicoDAO.get(1);
    }

    @AfterEach
    public void tearDown() {
        contenedor.reset();
        contenedor = null;
    }

    @Test
    public void testObtenerMedico() {
        assertEquals(medico, medicoDAO.get(medico.getId()));
    }

    @Test
    public void testObtenerTodos() {
        List<Medico> medicos = medicoDAO.getAll();
        assertTrue(medicos.contains(medico));
        assertTrue(medicos.contains(medicoDAO.get(2)));
    }

    @Test
    public void testGuardarMedico() {
        assertDoesNotThrow(() -> medicoDAO.save(medico));
    }

    @Test
    public void testGuardarYObtenerMedico() {
        Medico medicoNuevo = new Medico("Medico", "nuevo", 10, medico.getOs() ,medico.getEspecialidad());
        medicoDAO.save(medicoNuevo);
        assertEquals(medicoNuevo, medicoDAO.get(10));
    }

    @Test
    public void testGuardarMedicoConIdExistente() {
        Medico medicoNuevo = new Medico("Medico", "nuevo", 1, medico.getOs() ,medico.getEspecialidad());
        medicoDAO.save(medicoNuevo);
        Medico medicoGuardado = medicoDAO.get(1);
        assertEquals(medico, medicoGuardado);
        assertNotEquals(medicoNuevo, medicoGuardado);
    }

    @Test
    public void testModificarYActualizarMedico() {
        medico.setNombre("Nuevo nombre");
        medicoDAO.update(medico);
        Medico medicoModificado = medicoDAO.get(medico.getId());
        assertEquals("Nuevo nombre", medicoModificado.getNombre());
    }

    @Test
    public void testEliminar() {
        medicoDAO.delete(10);
        assertNull(medicoDAO.get(10));
    }
}
