import java.util.*;

public class Solution138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node head_cp = new Node(head.val);
        map.put(head, head_cp);
        Node cur = head, cur_cp = head_cp;
        while(cur.next != null){
            cur_cp.next = new Node(cur.next.val);
            map.put(cur.next, cur_cp.next);
            cur = cur.next;
            cur_cp = cur_cp.next;
        }
        cur = head;
        cur_cp = head_cp;
        for(; cur_cp != null; cur = cur.next, cur_cp = cur_cp.next) cur_cp.random = cur.random == null ? null : map.get(cur.random);
        return head_cp;
    }

}
