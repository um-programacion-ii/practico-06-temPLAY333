package servicios;

public class AtencionMedicoService {
    private static AtencionMedicoService instancia;

    private AtencionMedicoService() {
        // constructor privado para prevenir instanciación
    }

    public static AtencionMedicoService getInstancia() {
        if (instancia == null) {
            instancia = new AtencionMedicoService();
        }
        return instancia;
    }

}

