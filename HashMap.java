public class HashMap<K, V> implements Map<K, V>, Hashable<K, V> {
    private int size = 0;
    private LinkedMap<K, V>[] table = new LinkedMap[4];

    public HashMap() {
        this(4);
    }

    public HashMap(int size) {
        table = new LinkedMap[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedMap<>();
        }
    }

    @Override
    public int hashIndex(K key)
    {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            if(table[i]!=null) {
                count += table[i].size();
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < table.length; i++) {
            if(table[i].size()>0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        } else if(table[hashIndex(key)].size()>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < table.length; i++) {
            if(table[i].containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        } else if(table[hashIndex(key)]==null) {
            return null;
        }
        return(table[hashIndex(key)].get(key));
    }

    @Override
    public V put(K key, V value) {
        if(key==null) {
            throw new IllegalArgumentException();
        } else if(size>=table.length*(3d/4)) {
            LinkedMap<K, V>[] newTable = new LinkedMap[table.length*2];
            for (int i = 0; i < table.length; i++) {
                newTable[i] = table[i];
            }
            for (int i = table.length; i < newTable.length; i++) {
                newTable[i] = new LinkedMap<>();
            }
            table = newTable;
        }
        System.out.println(hashIndex(key) + " " + size);
        table[hashIndex(key)].put(key, value);
        size++;
        return value;
    }

    @Override
    public V remove(K key) {
        if(key==null) {
            throw new IllegalArgumentException();
        }
            size--;
        return table[hashIndex(key)].remove(key);
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedMap<>();
        }
    }
}
