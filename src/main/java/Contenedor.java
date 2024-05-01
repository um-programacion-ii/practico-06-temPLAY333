import entidades.Medico;
import entidades.Clinica;

import java.util.List;

public class Contenedor {
    private static Contenedor instance;
    private List<Medico> medicos;
    private List<Clinica> especialidades;

    private Contenedor() {
        // Aquí puedes instanciar las entidades que necesites
        // Por ejemplo:
        // pacientes = new ArrayList<>();
        // medicos = new ArrayList<>();
        // especialidades = new ArrayList<>();
    }

    public static Contenedor getInstance() {
        if (instance == null) {
            instance = new Contenedor();
        }
        return instance;
    }
}