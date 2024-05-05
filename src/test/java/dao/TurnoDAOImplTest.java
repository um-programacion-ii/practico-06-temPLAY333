package dao;

import contenedor.Contenedor;
import entidades.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void testGuardarTurno() {
        assertDoesNotThrow(() -> turnoDAO.save(turno));
    }

    @Test
    public void testObtenerTurno() {
        assertNull(turnoDAO.get(turno.getId()));
    }
}