public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode ans = new ListNode(head.val), cur = head.next, ansCur = ans;
        while (cur != null) {
            if (cur.val != ansCur.val) {
                ansCur.next = new ListNode(cur.val);
                ansCur = ansCur.next;
            }
            cur = cur.next;
        }
        return ans;
    }
}
