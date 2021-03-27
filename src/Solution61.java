public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        cur.next = head;
        k %= length;
        for (int i = 0; i < length - k; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int length = 0;
        ListNode fast = head, slow = head;
        while (fast != null) {
            length++;
            fast = fast.next;
        }
        fast = head;
        k %= length;
        if (k == length) return head;
        for (int i = 0; i < k + 1; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            fast = head;
            head = fast.next;
            fast.next = null;
            ListNode cur = head, pre = cur;
            while (cur != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = fast;
            return head;
        }
        ListNode pre = fast;
        while (fast != null) {
            pre = fast;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null){
            return head;
        }
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
        solu.rotateRight(head, 4);

    }
}
