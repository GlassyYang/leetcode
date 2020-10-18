public class Solution24 {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head, even = head.next, last = null;
        head = head.next;
        while(odd != null && even != null){
            if(last != null)
                last.next = even;
            last = odd;
            odd.next = even.next;
            even.next = odd;
            odd = odd.next;
            if(odd != null) even = odd.next;
            else even = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        ListNode ans = swapPairs(head);
        while(ans != null){
            System.out.println(ans.val);
            ans =ans.next;
        }
    }

}
