import java.util.ArrayList;
import java.util.Iterator;

public class ArrayMap<K, V> implements Map<K, V>, Iterable<MapItem<K, V>> {

    private ArrayList<MapItem<K, V>> list = new ArrayList<>();
    private Iterator<MapItem<K, V>> iterator = list.iterator();
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            MapItem<K, V> item = list.get(i);
            if(item.getKey().equals(key)) {
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey().equals(key)) {
                list.remove(i);
            }
        }
        list.add(new Item<K, V>(key, value));
        return value;
    }

    @Override
    public V remove(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey().equals(key)) {
                return list.remove(i).getValue();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        list = new ArrayList<MapItem<K, V>>();
    }

    @Override
    public Iterator<MapItem<K, V>> iterator() {
        return iterator;
    }
}
