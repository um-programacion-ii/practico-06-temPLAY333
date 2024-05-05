package excepciones;

public class EntidadNotNullException extends Exception {
    public EntidadNotNullException(String message) {
        super(message);
    }

    public EntidadNotNullException() {
        super("La entidad fue encontrada no nula");
    }
}