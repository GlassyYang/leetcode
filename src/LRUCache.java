import java.util.*;

public class LRUCache {

    private static class BothWayLinkedList{

        public BothWayLinkedList prev;
        public BothWayLinkedList next;
        int val;
        int key;
        public BothWayLinkedList(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    // 实现一个双向链表加哈希函数的LRU缓存
    private Map<Integer, BothWayLinkedList> map;
    private BothWayLinkedList head;
    private BothWayLinkedList tail;
    private int count;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.count = 0;
    }

    public int get(int key) {
        if(! map.containsKey(key)) return -1;
        BothWayLinkedList e = map.get(key);
        if(e == head) return e.val;
        if(e == tail) tail = e.prev;
        if(e.prev != null) e.prev.next = e.next;
        if(e.next != null) e.next.prev = e.prev;
        e.prev = null;
        e.next = head;
        head.prev = e;
        head = e;
        return e.val;
    }

    public void put(int key, int value) {
        BothWayLinkedList e;
        if(map.containsKey(key)){
            e = map.get(key);
            e.val = value;
            if(e == head) return;
            if(e.prev != null) e.prev.next = e.next;
            if(e.next != null) e.next.prev = e.prev;
            if(e == tail) tail = e.prev;
            e.prev = null;
            e.next = head;
            head.prev = e;
            head = e;
            return;
        }
        if(count < capacity){
            e = new BothWayLinkedList(value, key);
        }else{
            if(capacity == 1){
                map.remove(head.key);
                head.key = key;
                head.val = value;
                map.put(key, head);
                return;
            }
            e = tail;
            if(tail != null){
                tail = tail.prev;
                if(tail != null)tail.next = null;
            }
            map.remove(e.key);
        }
        e.prev = null;
        e.next = head;
        if(head != null) head.prev = e;
        head = e;
        e.val = value;
        e.key = key;
        if(count == 0) tail = e;
        map.put(key, e);
        count++;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

}
