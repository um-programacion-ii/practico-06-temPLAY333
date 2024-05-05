package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import servicios.AtencionMedicoService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class Medico {
    private static AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstancia();
    private String nombre;
    private String apellido;
    private int id;
    private List<ObraSocial> os;
    private Especialidad especialidad;
    private String consultorio;

    public Medico(String nombre, String apellido, int id, List<ObraSocial> os, Especialidad especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.os = os;
        this.especialidad = especialidad;

        List<String> consultorios = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        Random random = new Random();
        this.consultorio = consultorios.get(random.nextInt(consultorios.size()));
    }

    public Turno disponibilidad() {
        Random random = new Random();
        int hora = random.nextInt(24);
        int minuto = random.nextInt(60);
        String horario = String.format("%02d:%02d", hora, minuto);
        return new Turno(this, 1, horario, consultorio);
    }

    @Override
    public String toString(){
        return "- " + this.apellido + ", " + this.nombre;
    }
}
