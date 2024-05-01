package servicios;

import entidades.Paciente;

public class GestionTurnoService {
    private static GestionTurnoService instancia;

    private GestionTurnoService() {
        // constructor privado para prevenir instanciación
    }

    public static GestionTurnoService getInstancia() {
        if (instancia == null) {
            instancia = new GestionTurnoService();
        }
        return instancia;
    }

    public void pedirTurno(Paciente paciente) {

    }
}
