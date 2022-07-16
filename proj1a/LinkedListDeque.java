public class LinkedListDeque<T> {
    private class Node{
        private T item;
        private Node prev;
        private Node next;

        public Node(T t, Node pre, Node next){
            this.item = t;
            this.prev = pre;
            this.next = next;
        }
        public Node(Node prev, Node next){
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new Node( null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        size += 1;
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
    }

    public void addLast(T item){
        size += 1;
        Node node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        while (p != sentinel){
            System.out.println(p.item+" ");
            p = p.next;
        }
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        size -= 1;
        T firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return firstItem;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        size -=1;
        T lastItem= sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return lastItem;
    }

    public T get(int index){
        if (index >= size){
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }


}
