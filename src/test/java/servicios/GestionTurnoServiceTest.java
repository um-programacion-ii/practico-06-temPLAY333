package servicios;

import contenedor.Contenedor;
import entidades.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionTurnoServiceTest {
    private GestionTurnoService gestionTurnoService;
    private Medico medico;
    private Paciente paciente;
    private Contenedor contenedor;

    @BeforeEach
    public void setUp() {
        gestionTurnoService = GestionTurnoService.getInstancia();
        contenedor = new Contenedor();
        medico = contenedor.MedicosDB.get(1);
        paciente = contenedor.PacientesDB.get(1);
    }

    @Test
    public void testIngresarPaciente() {
        assertDoesNotThrow(() -> gestionTurnoService.ingresarPaciente(paciente));
    }

    @Test
    public void testMostrarMedicos() {
        assertNull(gestionTurnoService.mostrarMedicos(medico.getEspecialidad()));
        assertNull(gestionTurnoService.mostrarMedicos(paciente.getOs(), medico.getEspecialidad()));
    }

    @Test
    public void testCrearTurno() {
        assertDoesNotThrow(() -> gestionTurnoService.crearTurno(paciente, medico));
    }

    @Test
    public void testFinalizarTurno() {
        assertDoesNotThrow(() -> gestionTurnoService.finalizarTurno(paciente));
    }
}
