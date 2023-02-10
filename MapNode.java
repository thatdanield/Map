public class MapNode<K, V> extends Item<K, V> implements DoublyLinkedNode<K, V> {
    private DoublyLinkedNode<K, V> previous;
    private DoublyLinkedNode<K, V> next;

    public MapNode(K key, V value, DoublyLinkedNode<K, V> previous, DoublyLinkedNode<K, V> next) {
        super(key, value);
        this.previous = previous;
        this.next = next;
    }

    public MapNode(K key, V value) {
        super(key, value);
    }

    @Override
    public DoublyLinkedNode<K, V> getPrevious() {
        return previous;
    }

    @Override
    public void setPrevious(DoublyLinkedNode<K, V> node) {
        this.previous = node;
    }

    @Override
    public DoublyLinkedNode<K, V> getNext() {
        return next;
    }

    @Override
    public void setNext(DoublyLinkedNode<K, V> node) {
        this.next = node;
    }

    public void setValue(V value) {
        super.setValue(value);
    }
}
