package liurui.structures;

public interface ArrayListable {
    void add(int data);

    void insert(int index, int data);

    boolean contains(int data);

    int remove();

    int remove(int index);

    int getSize();

    boolean isEmpty();

    void clear();

    int get(int index);
}
