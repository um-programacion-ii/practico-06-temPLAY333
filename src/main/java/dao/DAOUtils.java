package dao;

import java.util.Map;

public class DAOUtils {
    public static <K, V> void saveIfAbsent(Map<K, V> map, K key, V value) {
        map.putIfAbsent(key, value);
    }
}
