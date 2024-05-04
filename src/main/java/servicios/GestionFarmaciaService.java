package servicios;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import entidades.Farmacia;
import entidades.Paciente;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instancia;
    private Farmacia farmacia = Farmacia.getInstancia();

    private GestionFarmaciaService() {
        // constructor privado para prevenir instanciación
    }

    public static GestionFarmaciaService getInstancia() {
        if (instancia == null) {
            instancia = new GestionFarmaciaService();
        }
        return instancia;
    }

    public boolean tenerReceta(Paciente paciente) {
        return true;
    }

    public Object darMedicamentos(Paciente paciente) {
        return null;
    }
}
