package liurui.v1.structure;

public class MyHashtable {
    private static class Entry {
        private int _key;
        private String _data;
        private Entry _next;

        public Entry(int key, String data) {
            this(key, data, null);
        }

        public Entry(int key, String data, Entry next) {
            this._key = key;
            this._data = data;
            this._next = next;
        }
    }

    private Entry[] _ary;
    private int _count = 0;

    public MyHashtable() {
        this(8);
    }

    public MyHashtable(int init) {
        _ary = new Entry[init];
    }

    public void set(int key, String value) {
        Entry entry = _ary[hashKey(key)];

        if (entry == null) {
            _ary[hashKey(key)] = new Entry(-1, null, new Entry(key, value));
            _count++;
        } else {
            while (entry != null) {
                if (entry._key == key) {
                    entry._data = value;
                    return;
                }
                if (entry._next == null) break;
                entry = entry._next;
            }
            entry._next = new Entry(key, value);
            _count++;
        }

        resize();
    }

    private void resize() {
        if (_count < _ary.length * 0.75) return;
        Entry[] newAry = new Entry[_ary.length * 2];

        for (int i = 0; i < _ary.length; i++) {
            Entry tmp = _ary[i];

            if (tmp == null || tmp._next == null) continue;
            Entry item = tmp._next;

            while (item != null) {
                int newIndex = item._key % newAry.length;

                if (newAry[newIndex] == null) {
                    newAry[newIndex] = new Entry(-1, null, new Entry(item._key, item._data));
                } else {
                    newAry[newIndex]._next = new Entry(item._key, item._data, newAry[newIndex]._next);
                }
                item = item._next;
            }
        }
        _ary = newAry;
    }

    public void remove(int key) {
        Entry entry = _ary[hashKey(key)];
        if (entry == null || entry._next == null) return;
        Entry prev = entry;
        entry = entry._next;

        while (entry != null) {
            if (entry._key == key) break;
            entry = entry._next;
        }

        if (entry != null) {
            prev._next = entry._next;
            _count--;
        }
    }


    public String get(int key) {
        Entry entry = getprivate(key);

        return entry == null ? null : entry._data;
    }

    public boolean contains(int key) {
        Entry entry = getprivate(key);

        return entry != null;
    }

    private Entry getprivate(int key) {
        Entry entry = _ary[hashKey(key)];
        if (entry == null || entry._next == null) return null;
        while (entry != null) {
            if (entry._key == key) return entry;
            entry = entry._next;
        }
        return null;
    }

    public int getCount() {
        return _count;
    }

    public int getSize() {
        return _ary.length;
    }

    private int hashKey(int key) {
        return key % _ary.length;
    }
}
