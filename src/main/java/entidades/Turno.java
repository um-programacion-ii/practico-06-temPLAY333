package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Turno {
    private Medico medico;
    private int id;
    private String horario;
    private String consultorio;
}
