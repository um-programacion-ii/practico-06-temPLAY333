package entidades;

import dao.MedicamentoDAO;
import lombok.Getter;
import lombok.Setter;
import servicios.GestionFarmaciaService;

import java.util.List;

@Getter
@Setter
public class Farmacia {
    private static Farmacia instancia;
    private MedicamentoDAO medicamentoDAO;

    private Farmacia() {
        // constructor privado para prevenir instanciación
    }

    public static Farmacia getInstancia() {
        if (instancia == null) {
            instancia = new Farmacia();
        }
        return instancia;
    }
}
