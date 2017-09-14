package liurui.structures;


/***
 * 散列表－使用链表法解决碰撞问题
 */
public class MyHashTable {
    public static class Entry {
        private int key;
        private String value;
        private Entry next;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Entry(int key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final static int DEFAULT_CAPACITY = 10;
    public final static float RESIZE_FACTOR = 0.75f;
    Entry[] list;
    int capacity = 0;//list数组已经使用的个数
    int size = 0; //元素的总个数

    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashTable(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        list = new Entry[capacity];
    }


    public void put(int key, String value) {
        int index = hash(key, list.length);

        if (list[index] == null) {
            list[index] = new Entry(-1, "", new Entry(key, value));
            capacity++;
            size++;
            resize();
        } else {
            Entry item = list[index].next;

            while (item != null) {
                if (item.key == key) {
                    item.value = value;
                    return;
                }
                item = item.next;
            }
            list[index].next = new Entry(key, value, list[index].next);
            size++;
        }
    }

    private void resize() {
        if (capacity < list.length * RESIZE_FACTOR) return;
        Entry[] oldList = list;
        list = new Entry[list.length * 2];
        capacity = 0;
        size = 0;

        for (int i = 0; i < oldList.length; i++) {
            if (oldList[i] == null) continue;

            for (Entry item = oldList[i].next; item != null; item = item.next) {
                put(item.key, item.value);
            }
        }
    }

    private int hash(int key, int count) {
        return Math.abs(Integer.valueOf(key).hashCode() % count);
    }

    public boolean contains(int key) {
        return getEntry(key) != null;
    }

    public String get(int key) {
        Entry entry = getEntry(key);

        return entry == null ? null : entry.value;
    }

    public Entry getEntry(int key) {
        if (isEmpty())  return null;
        int index = hash(key, list.length);

        if (list[index] == null) return null;
        Entry item = list[index].next;

        while (item != null) {
            if (item.key == key)
                return item;

            item = item.next;
        }
        return item;
    }

    public void remove(int key) {
        if (isEmpty()) return;
        int index = hash(key, list.length);

        if (list[index] == null) return;
        Entry pre = list[index];
        Entry item = list[index].next;

        while (item != null) {
            if (item.key == key) {
                pre.next = item.next;
                size--;
                break;
            }

            pre = item;
            item = item.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        list = new Entry[DEFAULT_CAPACITY];
        capacity = 0;
        size = 0;
    }
}
