package excepciones;

public class CantidadInsuficienteException extends Exception {
    public CantidadInsuficienteException(String message) {
        super(message);
    }

    public CantidadInsuficienteException() {
        super("La Farmacia no tiene el Stock suficiente");
    }
}