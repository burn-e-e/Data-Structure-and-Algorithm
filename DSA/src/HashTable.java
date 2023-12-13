import java.util.HashMap;

public class HashTable {
    private HashMap<Object, Object> map;

    public HashTable() {
        map = new HashMap<>();
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    public Object updateElement(Object theKey, Object theElement) {
        Object elementToUpdate = get(theKey);
        if (elementToUpdate != null) {
            put(theKey, theElement);
        }
        return elementToUpdate;
    }

    public Object updateKey(Object theKey, Object theNewKey) {
        Object elementToUpdate = get(theKey);
        if (elementToUpdate != null) {
            delete(theKey);
            put(theNewKey, elementToUpdate);
        }
        return elementToUpdate;
    }

    public void delete(Object theKey) {
        Object elementToDelete = get(theKey);
        if (elementToDelete != null) {
            map.remove(theKey);
        }
    }
}
