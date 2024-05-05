package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import servicios.AtencionMedicoService;

import java.util.List;

@Data
@AllArgsConstructor
public class Medico {
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstancia();
    private String nombre;
    private String apellido;
    private int id;
    private List<ObraSocial> os;
    private Especialidad especialidad;

    @Override
    public String toString(){
        return "- " + this.apellido + ", " + this.nombre;
    }
}
