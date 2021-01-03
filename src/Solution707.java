import java.util.*;


class MyLinkedList {

    static class LinkedNode<T> {
        LinkedNode<T>  prev;
        T val;
        LinkedNode<T> next;
        LinkedNode(T val) {
            this.val = val;
        }
    }

    LinkedNode<Integer> head;
    LinkedNode<Integer> tail;
    int length;
    // 使用双链表实现这个玩意儿
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new LinkedNode<>(-1);
        tail = head;
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        System.out.println(String.format("get: (%d)", index));
        if(index >= length || index < 0) return -1;
        int count = 0;
        LinkedNode<Integer> cur = head.next;
        while(count < index) {
            cur = cur.next;
            count++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        System.out.println(String.format("addAtHead: (%d)", val));
        LinkedNode<Integer> newNode = new LinkedNode<>(val);
        newNode.next = head.next;
        if(newNode.next != null) newNode.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        length++;
        if (tail == head) tail = head.next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        System.out.println(String.format("addAtTail: (%d)", val));
        LinkedNode<Integer> newNode = new LinkedNode<>(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        System.out.println(String.format("addAtIndex: (%d, %d)", index, val));
        if (index > length || index < 0) return;
        LinkedNode<Integer> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        LinkedNode<Integer> newNode = new LinkedNode<>(val);
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next = newNode;
        if(newNode.next != null) newNode.next.prev = newNode;
        if(cur == tail) tail = newNode;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        System.out.println(String.format("deletedAtIndex: (%d)", index));
        if(index >= length || index < 0) return;
        if (index == length - 1) {
            tail = tail.prev;
            tail.next = null;
            length--;
            return;
        }
        LinkedNode<Integer> cur = head.next;
        int trueLength = 0;
        for (LinkedNode<Integer> i = head.next; i != null; i = i.next) trueLength++;
        cur = head.next;
        for (int i = 0; i < index; i++) cur = cur.next;
        System.out.println(String.format("delete length: (%d, %d)", length, trueLength));
        cur.prev.next = cur.next;
        if(cur.next != null) cur.next.prev = cur.prev;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class Solution707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(24);
        System.out.println(linkedList.get(1));
        linkedList.addAtTail(18);
        linkedList.deleteAtIndex(1);
        linkedList.get(1);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3, 0);
//        linkedList.deleteAtIndex(2);
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(4);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        System.out.println(linkedList.get(1));  //返回2
//        linkedList.deleteAtIndex(-1);            //现在链表是1-> 3
//        System.out.println(linkedList.get(1));  //1
    }

}
