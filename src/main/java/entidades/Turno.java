package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Turno {
    private Medico medico;
    private int horario;
    private String consultorio;
}
