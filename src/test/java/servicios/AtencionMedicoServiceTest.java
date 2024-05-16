package servicios;

import contenedor.Contenedor;
import entidades.Medico;
import entidades.Paciente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.Mockito.when;

public class AtencionMedicoServiceTest {
    private AtencionMedicoService atencionMedicoService;
    private Medico medico;
    private Paciente paciente;
    private Contenedor contenedor;
    private Random random;

    @BeforeEach
    public void setUp() {
        atencionMedicoService = AtencionMedicoService.getInstancia();
        contenedor = new Contenedor();
        contenedor.init();
        medico = contenedor.MedicosDB.get(1);
        paciente = contenedor.PacientesDB.get(1);
        random = Mockito.mock(Random.class);  // Crea un doble de Random
        atencionMedicoService.setRandom(random);
    }

    @AfterEach
    public void tearDown() {
        contenedor.reset();
        contenedor = null;
    }

    @Test
    public void testTenerTurno() {
        paciente.setTurno(null);
        assertFalse(atencionMedicoService.tenerTurno(paciente));

        paciente.setTurno(contenedor.TurnosDB.get(1));
        assertTrue(atencionMedicoService.tenerTurno(paciente));
    }

    @Test
    public void testAtenderPacienteConReceta() {
        when(random.nextBoolean()).thenReturn(true);  // Simula que Random.nextBoolean() siempre devuelve true

        atencionMedicoService.atenderPaciente(paciente, medico);
        assertNotNull(paciente.getReceta());
    }

    @Test
    public void testAtenderPacienteSinReceta() {
        when(random.nextBoolean()).thenReturn(false);  // Simula que Random.nextBoolean() siempre devuelve false

        atencionMedicoService.atenderPaciente(paciente, medico);
        assertNull(paciente.getReceta());
    }
}
