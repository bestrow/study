package array;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. array.Array is full.");
        }
        data[size] = e;
        size++;
    }


    public E remove(int index) {
        E ret;
        ret = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return ret;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    //======================
    public E get(int index) {
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }


}
