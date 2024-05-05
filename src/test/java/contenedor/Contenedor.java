package contenedor;

import dao.*;
import entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Contenedor {
    public MedicamentoDAO MedicamentosDB;
    public MedicoDAO MedicosDB;
    public PacienteDAO PacientesDB;
    public TurnoDAO TurnosDB;

    public Contenedor() {
        reset();
    }

    public void reset() {
        MedicamentosDB = MedicamentoDAOImpl.getInstance();
        MedicosDB = MedicoDAOImpl.getInstance();
        PacientesDB = PacienteDAOImpl.getInstance();
        TurnosDB = TurnoDAOImpl.getInstance();

        // Crear Obras Sociales
        ObraSocial os1 = new ObraSocial("Medife", 1);
        ObraSocial os2 = new ObraSocial("OsPE",2);

        List<ObraSocial> listOs1 = new ArrayList<>();
        listOs1.add(os1);
        List<ObraSocial> listOs2 = new ArrayList<>();
        listOs2.add(os2);

        // Crear Especialidades
        Especialidad esp1 = new Especialidad("Cardiologo");
        Especialidad esp2 = new Especialidad("Dermatologo");

        // Crear Medicos
        String[] nombresMedicos = {"Juan", "Pedro", "Ana", "Maria", "Carlos", "Luis", "Sofia", "Laura"};
        String[] apellidosMedicos = {"Perez", "Gomez", "Lopez", "Rodriguez", "Sanchez", "Torres", "Gonzalez", "Martinez"};
        List<List<ObraSocial>> listas = new ArrayList<>();
        listas.add(listOs1);
        listas.add(listOs2);
        Especialidad[] especialidades = {esp1, esp2};
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <2 ; k++) {
                    int randomIndex = random.nextInt(nombresMedicos.length);
                    Medico medico = new Medico(nombresMedicos[randomIndex], apellidosMedicos[randomIndex], i + 1, listas.get(j), especialidades[k]);
                    MedicosDB.save(medico);
                }
            }
        }

        // Crear Turnos
        Medico medico1 = MedicosDB.get(1); // Asume que el medico con id 1 existe
        Medico medico2 = MedicosDB.get(2); // Asume que el medico con id 2 existe
        Turno turno1 = new Turno(medico1, 1, "10:00", "A");
        Turno turno2 = new Turno(medico2, 2, "11:00", "B");
        TurnosDB.save(turno1);
        TurnosDB.save(turno2);

        // Crear Pacientes
        String[] nombresPacientes = {"Mariana", "Lopez"};
        String[] apellidosPacientes = {"Ricardo", "Corazon de Leon"};
        Paciente paciente = new Paciente(nombresPacientes[0], apellidosPacientes[0],2, os1, null, null);
        PacientesDB.save(paciente);
        paciente = new Paciente(nombresPacientes[1], apellidosPacientes[1], 1, os2, null, null);
        PacientesDB.save(paciente);
        paciente = new Paciente("Lionhart", "Euler", 3, os1, turno1, null);
        PacientesDB.save(paciente);

        // Crear Medicamentos
        Medicamento medicamento = new Medicamento("Paracetamol",10,1);
        MedicamentosDB.save(medicamento);
        medicamento = new Medicamento("Buscapina",4,2);
        MedicamentosDB.save(medicamento);
    }
}