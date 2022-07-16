public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int length;
    private int front;
    private int last;
    public ArrayDeque(){
        items = (T[])new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    private int minusOne(int index){
        if(index == 0){
            return length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index, int length) {
        if(index == length -1){
            return 0;
        }
        return index + 1;
    }

    private void grow() {
        T[] newArray = (T[])new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != last){
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = length;
        last = ptr2;
        items = newArray;
        length *= 2;
    }

    public void addFirst(T t){
        if(size == length - 1){
            grow();
        }
        front = minusOne(front);
        items[front] = t;
        size ++;
    }

    public void addLast(T t){
        if(size == length - 1){
            grow();
        }
        items[last] = t;
        last = plusOne(last,length);
        size ++;
    }

    //shrink the half length of items
    private void shrink(){
        T[] newArray = (T[])new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 4;
        while (ptr1 != last){
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1,length);
            ptr2 = plusOne(ptr2,length / 2);
        }
        front = length / 4;
        last = ptr2;
        items = newArray;
        length /= 2;
    }

    public T removeFirst(){
        if(length >= 16 && length / size > 4){
            shrink();
        }
        if(size == 0){
            return null;
        }
        T res = items[front];
        front = plusOne(front,length);
        size --;
        return res;
    }

    public T removeLast(){
        if(length >= 16 && length / size > 4){
            shrink();
        }
        if(size == 0){
            return null;
        }
        last = minusOne(last);
        size --;
        return items[last];
    }

    public T get(int index){
        if (index >= size) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return items[ptr];
    }

    /** print the entire deque from front to end. */
    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.print(items[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
