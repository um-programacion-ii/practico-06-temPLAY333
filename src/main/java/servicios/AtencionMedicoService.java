package servicios;

import dao.MedicamentoDAO;
import entidades.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
public class AtencionMedicoService {
    private static AtencionMedicoService instancia;
    private Farmacia farmacia = Farmacia.getInstancia();
    private Random random = new Random();

    private AtencionMedicoService() {
        // constructor privado para prevenir instanciación
    }

    public static AtencionMedicoService getInstancia() {
        if (instancia == null) {
            instancia = new AtencionMedicoService();
        }
        return instancia;
    }

    public boolean tenerTurno (Paciente paciente){
        if (paciente.getTurno() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void atenderPaciente (Paciente paciente, Medico medico) {
        MedicamentoDAO medicamentosPosibles = farmacia.getMedicamentoDAO();

        if (random.nextBoolean()) {
            int cantidadMedicamentos = random.nextInt(2) + 1; // Entre 1 y 2 medicamentos
            List<Medicamento> medicamentos = new ArrayList<>();

            for (int i = 0; i < cantidadMedicamentos; i++) {
                int dosisAleatoria = random.nextInt(20) + 1;  // Dosis entre 1 y 20
                int idMedicamento = random.nextInt(medicamentosPosibles.getAll().size())+1;
                String nombreMedicamento = medicamentosPosibles.get(idMedicamento).getNombre();

                Medicamento medicamentoAleatorio = new Medicamento(nombreMedicamento,
                                                                   dosisAleatoria,
                                                                   idMedicamento);

                if (!medicamentos.contains(medicamentoAleatorio)) {
                    medicamentos.add(medicamentoAleatorio);
                }
            }
            paciente.setReceta(new Receta(medicamentos, medico,"Cuidese"));
        }
    }
}

