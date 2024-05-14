package servicios;

import entidades.Farmacia;
import entidades.Medicamento;
import entidades.Paciente;
import excepciones.CantidadInsuficienteException;
import excepciones.EntidadNullException;

import java.util.ArrayList;
import java.util.List;

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

    public boolean tenerReceta(Paciente paciente) throws EntidadNullException {
        if (paciente.getReceta() == null) {
            throw new EntidadNullException();
        } else {
            return true;
        }
    }

    public void darMedicamentos(Paciente paciente) throws CantidadInsuficienteException {
        for (Medicamento medicamento : paciente.getReceta().getMedicamentos()) {
            Medicamento medicGuardado = farmacia.getMedicamentoDAO().get(medicamento.getId());
            if (medicGuardado.getCantidad() < medicamento.getCantidad()) {
                throw new CantidadInsuficienteException();
            }
            medicGuardado.setCantidad(medicGuardado.getCantidad()-medicamento.getCantidad());
        }
    }

    public void pedidoADrogueria(List<Medicamento> medicamentos) {
        for (Medicamento medicamento : medicamentos) {
            medicamento.setCantidad(medicamento.getCantidad()+100);
        }
    }

    public void agregarMedicamento(String nombre){
        Medicamento nuevo = new Medicamento(nombre,0,10);

        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(nuevo);
        pedidoADrogueria(medicamentos);

        farmacia.getMedicamentoDAO().save(nuevo);
    }
}
