public class Item<K, V> implements MapItem<K, V> {
    private K key;
    private V value;

    public void setValue(V value) {
        this.value = value;
    }

    public Item(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
