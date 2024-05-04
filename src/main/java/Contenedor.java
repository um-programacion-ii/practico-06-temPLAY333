import dao.*;
import entidades.Medico;
import entidades.Clinica;

public class Contenedor {
    public static MedicamentoDAO MedicamentosDB = new MedicamentoDAOImpl();
    public static MedicoDAO MedicosDB = new MedicoDAOImpl();
    public static PacienteDAO PacientesDB = new PacienteDAOImpl();

    private Contenedor() {}

    public static void inicializar() {
        // Crear instancias de Medico
        // Medico medico1 = new Medico();
        // Medico medico2 = new Medico();
        // ...

        // MedicosDB.save(medico1);
        // MedicosDB.save(medico2);
        // ...
    }
}