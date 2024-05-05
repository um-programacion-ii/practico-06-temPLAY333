package entidades;

public class EntidadDeDB {
    private static int nextId = 1;
    private int id;

    public EntidadDeDB() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }
}
