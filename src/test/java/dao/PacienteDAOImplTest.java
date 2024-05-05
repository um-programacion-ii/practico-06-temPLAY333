package dao;

import contenedor.Contenedor;
import entidades.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void testGuardarPaciente() {
        assertDoesNotThrow(() -> pacienteDAO.save(paciente));
    }

    @Test
    public void testObtenerPaciente() {
        assertNull(pacienteDAO.get(paciente.getDni()));
    }
}