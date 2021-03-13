public class Solution705 {



}

class MyHashSet {
    boolean[] set;
    private static final int length = 1000001;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[length];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}
