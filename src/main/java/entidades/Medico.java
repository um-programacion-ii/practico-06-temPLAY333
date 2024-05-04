package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import servicios.AtencionMedicoService;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Medico {
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstancia();
    private String nombre;
    private String apellido;
    private int dni;
    private List<ObraSocial> os;
    private Especialidad especialidad;

    @Override
    public String toString(){
        return "- " + this.apellido + ", " + this.nombre;
    }
}
