package liurui;

public class MyHashMap {
    public static class Entry {
        private int _key;
        private String _value;
        private Entry _next;


        public Entry(int _key, String _value, Entry next) {
            this._key = _key;
            this._value = _value;
            _next = next;
        }

        public int get_key() {
            return _key;
        }

        public String get_value() {
            return _value;
        }

        public void set_value(String _value) {
            this._value = _value;
        }

        public Entry get_next() {
            return _next;
        }

        public void set_next(Entry _next) {
            this._next = _next;
        }
    }

    private Entry[] _ary = new Entry[10];
    private int _len = 0;

    public void add(int key, String value) {
        int i = hashKey(key);
        Entry item = _ary[i];

        if (item == null) {
            _ary[i] = new Entry(-1, "", new Entry(key, value, null));
        } else {
            item.set_next(new Entry(key, value, item.get_next()));
        }
        _len++;
    }

    public String get(int key) {
        int i = hashKey(key);
        Entry item = _ary[i];

        if (item != null && item.get_next() != null) {
            Entry next = item.get_next();

            while (next != null) {
                if (next.get_key() == key) {
                    return next.get_value();
                }

                next = next.get_next();
            }
        }
        return null;
    }

    public void remove(int key) {
        int i = hashKey(key);
        Entry item = _ary[i];


        if (item != null && item.get_next() != null) {
            Entry prev = item;
            Entry next = item.get_next();

            while (next != null) {
                if (next.get_key() == key) {
                    prev._next = next.get_next();
                    _len--;
                    return;
                }
                prev = next;
                next = next.get_next();
            }
        }
    }

    public boolean hasKey(int key) {
        return get(key) != null;
    }

    private int hashKey(int key) {
        return key % _ary.length;
    }

    public int getLen() {
        return _len;
    }

    public int getSize() {
        return _ary.length;
    }
}
