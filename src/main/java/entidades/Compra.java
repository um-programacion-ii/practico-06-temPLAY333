package entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Compra {
    private List<Medicamento> medicamentos;
    private Paciente paciente;
    private int valor;
}
