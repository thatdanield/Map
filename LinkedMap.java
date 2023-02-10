public class LinkedMap<K, V> implements Map<K, V> {
    private MapNode<K, V> start;
    private int size = 0;
    @Override
    public int size() {
        MapNode<K, V> node = start;
        int count = 0;
        while(node!=null) {
            count++;
            node = (MapNode<K, V>) node.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> node = start;
        while(node!=null) {
            if(key.equals(node.getKey())) {
                return true;
            }
            node = (MapNode<K, V>) node.getNext();
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        if(value==null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> node = start;
        while(node!=null) {
            if(value.equals(node.getValue())) {
                return true;
            }
            node = (MapNode<K, V>) node.getNext();
        }
        return false;
    }

    @Override
    public V get(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> node = start;
        while(node!=null) {
            if(key.equals(node.getKey())) {
                return node.getValue();
            }
            node = (MapNode<K, V>) node.getNext();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> node = start;
        while(node!=null) {
            if(key.equals(node.getKey())) {
                remove(key);
            }
            node = (MapNode<K, V>) node.getNext();
        }
        size++;
        MapNode<K, V> newNode = new MapNode<>(key, value, null, start);
        start = newNode;
        if(start.getNext()!=null) {
            start.getNext().setPrevious(start);
        }
        return value;
    }

    @Override
    public V remove(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
        MapNode<K, V> node = start;
        while(node!=null) {
            if(key.equals(node.getKey())) {
                V value = node.getValue();
                if(node.getPrevious()!=null) {
                    node.getPrevious().setNext(node.getNext());
                } else if(node.getNext()!=null) {
                    start = (MapNode<K, V>) node.getNext();
                } else {
                    start = null;
                }
                size--;
                return value;
            }
            node = (MapNode<K, V>) node.getNext();
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        start = null;
    }
}
