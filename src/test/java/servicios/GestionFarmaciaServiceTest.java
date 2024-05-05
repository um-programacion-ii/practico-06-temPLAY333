package servicios;

import contenedor.Contenedor;
import entidades.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionFarmaciaServiceTest {
    private GestionFarmaciaService gestionFarmaciaService;
    private Paciente paciente;
    private Contenedor contenedor;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = GestionFarmaciaService.getInstancia();
        contenedor = new Contenedor();
        paciente = contenedor.PacientesDB.get(1);
    }

    @Test
    public void testTenerReceta() {
        assertTrue(gestionFarmaciaService.tenerReceta(paciente));
    }

    @Test
    public void testDarMedicamentos() {
        assertNull(gestionFarmaciaService.darMedicamentos(paciente));
    }
}