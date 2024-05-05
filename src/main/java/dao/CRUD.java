package dao;

import java.util.List;

public interface CRUD<T> {
    T get(int id); // Read
    List<T> getAll(); // Read
    void save(T t); // Create
    void update(T t, String[] params); // Update
    void delete(T t); // Delete
}