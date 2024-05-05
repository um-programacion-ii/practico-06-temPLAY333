package servicios;

import contenedor.Contenedor;
import entidades.Medico;
import entidades.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtencionMedicoServiceTest {
    private AtencionMedicoService atencionMedicoService;
    private Medico medico;
    private Paciente paciente;
    private Contenedor contenedor;

    @BeforeEach
    public void setUp() {
        atencionMedicoService = AtencionMedicoService.getInstancia();
        contenedor = new Contenedor();
        medico = contenedor.MedicosDB.get(1);
        paciente = contenedor.PacientesDB.get(1);
    }

    @Test
    public void testTenerTurno() {
        assertTrue(atencionMedicoService.tenerTurno(paciente));
    }

    @Test
    public void testAtenderPaciente() {
        assertNull(atencionMedicoService.atenderPaciente(medico, paciente));
    }
}
