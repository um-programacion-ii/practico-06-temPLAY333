package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import servicios.AtencionMedicoService;

@Getter
@Setter
@AllArgsConstructor
public class Medico {
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstancia();
    private String nombre;
    private String apellido;
    private Especialidad especialidad;

    @Override
    public String toString() {
        return "";
    }
}
