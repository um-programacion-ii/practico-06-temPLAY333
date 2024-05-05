package dao;

import contenedor.Contenedor;
import entidades.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicoDAOImplTest {
    private MedicoDAO medicoDAO;
    private Contenedor contenedor;
    private Medico medico;

    @BeforeEach
    public void setUp() {
        contenedor = new Contenedor();
        medicoDAO = contenedor.MedicosDB;
        medico = medicoDAO.get(1);
    }

    @Test
    public void testGuardarMedico() {
        assertDoesNotThrow(() -> medicoDAO.save(medico));
    }

    @Test
    public void testObtenerMedico() {
        assertNull(medicoDAO.get(medico.getDni()));
    }
}
