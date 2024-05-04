package dao;

import entidades.Turno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnoDAOImpl implements TurnoDAO{
    private Map<Integer, Turno> turnos = new HashMap<>();

    @Override
    public Turno get(int id) {
        return turnos.get(id);
    }

    @Override
    public List<Turno> getAll() {
        return new ArrayList<>(turnos.values());
    }

    @Override
    public void save(Turno turno) {
        turnos.put(turno.getId(), turno);
    }

    @Override
    public void update(Turno turno, String[] params) {
        turnos.put(turno.getId(), turno);
    }

    @Override
    public void delete(Turno turno) {
        turnos.remove(turno.getId());
    }
}
