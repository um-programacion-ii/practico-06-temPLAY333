package dao;

import contenedor.Contenedor;
import entidades.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteDAOImplTest {
    private PacienteDAO pacienteDAO;
    private Contenedor contenedor;
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        contenedor = new Contenedor();
        pacienteDAO = contenedor.PacientesDB;
        paciente = pacienteDAO.get(1);
    }

    @Test
    public void testObtenerPaciente() {
        assertEquals(paciente, pacienteDAO.get(paciente.getId()));
    }

    @Test
    public void testObtenerTodos() {
        List<Paciente> pacientes = pacienteDAO.getAll();
        assertTrue(pacientes.contains(paciente));
        assertTrue(pacientes.contains(pacienteDAO.get(2)));
    }

    @Test
    public void testGuardarPaciente() {
        assertDoesNotThrow(() -> pacienteDAO.save(paciente));
    }

    @Test
    public void testGuardarYObtenerPaciente() {
        Paciente pacienteNuevo = new Paciente("Paciente", "nuevo", 10, paciente.getOs(), null, null);
        pacienteDAO.save(pacienteNuevo);
        assertEquals(pacienteNuevo, pacienteDAO.get(10));
    }

    @Test
    public void testGuardarPacienteConIdExistente() {
        Paciente pacienteNuevo = new Paciente("Paciente", "nuevo", 1, paciente.getOs(), null, null);
        pacienteDAO.save(pacienteNuevo);
        Paciente pacienteGuardado = pacienteDAO.get(1);
        assertEquals(paciente, pacienteGuardado);
        assertNotEquals(pacienteNuevo, pacienteGuardado);
    }

    @Test
    public void testModificarYActualizarPaciente() {
        paciente.setNombre("Nuevo nombre");
        pacienteDAO.update(paciente);
        Paciente pacienteModificado = pacienteDAO.get(paciente.getId());
        assertEquals("Nuevo nombre", pacienteModificado.getNombre());
    }

    @Test
    public void testEliminar() {
        pacienteDAO.delete(paciente);
        assertNull(pacienteDAO.get(paciente.getId()));
    }
}