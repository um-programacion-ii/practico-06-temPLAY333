package dao;

import contenedor.Contenedor;
import entidades.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoDAOImplTest {
    private TurnoDAO turnoDAO;
    private Contenedor contenedor;
    private Turno turno;

    @BeforeEach
    public void setUp() {
        contenedor = new Contenedor();
        turnoDAO = contenedor.TurnosDB;
        turno = turnoDAO.get(1);
    }

    @Test
    public void testObtenerTurno() {
        assertEquals(turno, turnoDAO.get(turno.getId()));
    }

    @Test
    public void testObtenerTodos() {
        List<Turno> turnos = turnoDAO.getAll();
        assertTrue(turnos.contains(turno));
        assertTrue(turnos.contains(turnoDAO.get(2)));
    }

    @Test
    public void testGuardarTurno() {
        assertDoesNotThrow(() -> turnoDAO.save(turno));
    }

    @Test
    public void testGuardarYObtenerTurno() {
        Turno turnoNuevo = new Turno(turno.getMedico(),10,"10:10", "A");
        turnoDAO.save(turnoNuevo);
        assertEquals(turnoNuevo, turnoDAO.get(10));
    }

    @Test
    public void testGuardarTurnoConIdExistente() {
        Turno turnoNuevo = new Turno(turno.getMedico(),1,"10:30", "A");
        turnoDAO.save(turnoNuevo);
        Turno turnoGuardado = turnoDAO.get(1);
        assertEquals(turno, turnoGuardado);
        assertNotEquals(turnoNuevo, turnoGuardado);
    }

    @Test
    public void testModificarYActualizarTurno() {
        turno.setHorario("Nueva hora");
        turnoDAO.update(turno);
        Turno turnoModificado = turnoDAO.get(turno.getId());
        assertEquals("Nueva hora", turnoModificado.getHorario());
    }

    @Test
    public void testEliminar() {
        turnoDAO.delete(turno);
        assertNull(turnoDAO.get(turno.getId()));
    }
}