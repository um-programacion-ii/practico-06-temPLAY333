package servicios;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;

    private GestionFarmaciaService() {
        // constructor privado para prevenir instanciación
    }

    public static GestionFarmaciaService getInstancia() {
        if (instancia == null) {
            instancia = new GestionFarmaciaService();
        }
        return instancia;
    }
}
