public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode pre = head, cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        k %= length;
        cur = head;
        int count = 0;
        while(cur.next != null){
            count++;
            cur = cur.next;
            if(count > k) pre = pre.next;
        }
        cur.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution61 solu = new Solution61();
        ListNode head, cur = head = new ListNode(1);
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        solu.rotateRight(head, 2);

    }
}
