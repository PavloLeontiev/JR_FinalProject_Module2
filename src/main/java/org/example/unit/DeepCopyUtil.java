package org.example.unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DeepCopyUtil {
    public static <K, V> HashMap<K, LimitedHashSet<V>> deepCloneHashMap(HashMap<K, LimitedHashSet<V>> original) {
        HashMap<K, LimitedHashSet<V>> clonedMap = new HashMap<>();
        for (Map.Entry<K, LimitedHashSet<V>> entry : original.entrySet()) {
            K key = entry.getKey();
            LimitedHashSet<V> originalList = entry.getValue();
            LimitedHashSet<V> clonedList = new LimitedHashSet<>(originalList);
            clonedMap.put(key, clonedList);
        }
        return clonedMap;
    }
}
