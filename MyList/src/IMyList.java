public interface IMyList <T>{

    int size();
    int getCapacity();
    T get(int index);
    T set(int index, T data);
    T remove(int index);
    void add(T data);
    String toString();
    int indexOf(T data);
    int lastIndexOf(T data);
    boolean isEmpty();
    T[] toArray();
    void clear();
    MyList<T> subList(int start, int finish);
    boolean contains(T data);


}
