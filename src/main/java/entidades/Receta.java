package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Receta {
    private List<Medicamento> medicamentos;
    private Medico medico;
    private String datos;
}
