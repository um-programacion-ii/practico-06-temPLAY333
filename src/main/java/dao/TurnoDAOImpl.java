package dao;

import entidades.Medico;
import entidades.Turno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnoDAOImpl implements TurnoDAO {
    private static TurnoDAOImpl instance;
    private Map<Integer, Turno> turnos = new HashMap<>();

    private TurnoDAOImpl() {
        // constructor privado para prevenir instanciación
    }

    public static TurnoDAOImpl getInstance() {
        if (instance == null) {
            instance = new TurnoDAOImpl();
        }
        return instance;
    }

    @Override
    public void resetInstance() {
        instance = null;
    }

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
        DAOUtils.saveIfAbsent(turnos, turno.getId(), turno);
    }
    @Override
    public void update(Turno turno) {
        turnos.put(turno.getId(), turno);
    }

    @Override
    public void delete(int id) {
        turnos.remove(id);
    }
}
