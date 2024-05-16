package servicios;

import contenedor.Contenedor;
import entidades.*;
import excepciones.EntidadNotNullException;
import excepciones.EntidadNullException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        contenedor.init();
        medico = contenedor.MedicosDB.get(1);
        paciente = contenedor.PacientesDB.get(1);
    }

    @AfterEach
    public void tearDown() {
        contenedor.reset();
        contenedor = null;
    }

    @Test
    public void testIngresarPaciente() {
        Paciente pacienteNuevo = new Paciente("hola","tul",10,null, null, null);
        assertDoesNotThrow(() -> gestionTurnoService.ingresarPaciente(pacienteNuevo));
        Paciente pacienteGuardado = contenedor.PacientesDB.get(10);
        assertNotNull(pacienteGuardado);
        assertEquals(pacienteNuevo, pacienteGuardado);
    }

    @Test
    public void testMostrarMedicosPorEspecialidad() {
        Especialidad especialidad = medico.getEspecialidad();
        List<Medico> medicos = gestionTurnoService.mostrarMedicos(especialidad);
        for (Medico medico : medicos) {
            assertEquals(especialidad, medico.getEspecialidad());
        }
    }

    @Test
    public void testMostrarMedicosPorObraSocialYEspecialidad() {
        ObraSocial os = medico.getOs().get(0);
        Especialidad especialidad = medico.getEspecialidad();
        List<Medico> medicos = gestionTurnoService.mostrarMedicos(os, especialidad);
        for (Medico medico : medicos) {
            assertEquals(especialidad, medico.getEspecialidad());
            assertTrue(medico.getOs().contains(os));
        }
    }

    @Test
    public void testCrearTurno() {
        assertDoesNotThrow(() -> gestionTurnoService.crearTurno(paciente, medico));
        assertNotNull(paciente.getTurno());
        assertEquals(medico, paciente.getTurno().getMedico());
    }

    @Test
    public void testCrearTurnoExcepcion() {
        Paciente pacienteConTurno = contenedor.PacientesDB.get(3);
        assertThrows(EntidadNotNullException.class, () -> gestionTurnoService.crearTurno(pacienteConTurno, medico));
    }

    @Test
    public void testFinalizarTurno() {
        Paciente pacienteConTurno = contenedor.PacientesDB.get(3);
        assertDoesNotThrow(() -> gestionTurnoService.finalizarTurno(pacienteConTurno));
        assertNull(pacienteConTurno.getTurno());
    }

    @Test
    public void testFinalizarTurnoExcepcion() {
        Paciente pacienteSinTurno = contenedor.PacientesDB.get(2);
        assertThrows(EntidadNullException.class, () -> gestionTurnoService.finalizarTurno(pacienteSinTurno));
    }
}
