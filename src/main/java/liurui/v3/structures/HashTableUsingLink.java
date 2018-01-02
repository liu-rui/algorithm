package liurui.v3.structures;

import liurui.structures.Hashable;
import liurui.structures.Item;

import java.util.List;

public class HashTableUsingLink implements Hashable {
    public static class Entry {
        private int key;
        private String value;
        private Entry next;

        public Entry() {
        }

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Entry(int key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }


    static final float FACTOR = 0.75f;
    Entry[] list = new Entry[4];
    int use;
    int size;

    @Override
    public void put(int key, String value) {
        int hash = hash(key, list.length);
        Entry item = new Entry(key, value);

        if (list[hash] == null) {
            list[hash] = new Entry(-1, null, item);
            use++;
            size++;
            resize();
        } else {
            Entry tmp = list[hash].getNext();

            while (tmp != null) {
                if (tmp.key == key) {
                    tmp.setValue(value);
                    return;
                }
                tmp = tmp.getNext();
            }
            item.setNext(list[hash].getNext());
            list[hash].setNext(item);
            size++;
        }
    }

    @Override
    public boolean contains(int key) {
        return getEntry(key) != null;
    }

    @Override
    public String get(int key) {
        Entry entry = getEntry(key);

        return entry == null ? null : entry.getValue();
    }

    @Override
    public void remove(int key) {
        int hash = hash(key, list.length);

        if (list[hash] == null) {
            return;
        } else {
            Entry prev = list[hash];
            Entry tmp = prev.getNext();

            while (tmp != null) {
                if (tmp.getKey() == key) {
                    prev.setNext(tmp.getNext());
                    size--;
                    return;
                }
                prev = tmp;
                tmp = tmp.getNext();
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        list = new Entry[4];
        use = size = 0;
    }

    private void resize() {
        if (use < list.length * FACTOR) return;
        Entry[] oldList = list;
        use = 0;
        size = 0;
        list = new Entry[list.length * 2];

        for (int i = 0; i < oldList.length; i++) {
            if (oldList[i] == null) continue;

            for (Entry item = oldList[i].getNext(); item != null; item = item.getNext()) {
                put(item.getKey(), item.getValue());
            }
        }
    }

    private Entry getEntry(int key) {
        int hash = hash(key, list.length);

        if (list[hash] == null) {
            return null;
        }

        Entry tmp = list[hash].getNext();


        while (tmp != null) {
            if (tmp.key == key) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    private int hash(int key, int count) {
        return key % count;
    }
}
