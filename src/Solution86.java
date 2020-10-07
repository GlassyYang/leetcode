public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(), r = new ListNode(), lc = l, rc = r;
        while(head != null){
            if(head.val < x){
                lc.next = head;
                lc = lc.next;
            }else{
                rc.next = head;
                rc = rc.next;
            }
            head = head.next;
        }
        rc.next = null;
        lc.next = r.next;
        return l.next;
    }
}
