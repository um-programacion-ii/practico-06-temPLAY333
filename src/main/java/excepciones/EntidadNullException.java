package excepciones;

public class EntidadNullException extends Exception {
    public EntidadNullException(String message) {
        super(message);
    }

    public EntidadNullException() {
        super("La entidad fue encontrada nula");
    }
}