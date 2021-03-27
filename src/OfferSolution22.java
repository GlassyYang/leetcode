public class OfferSolution22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast =head, slow = head;
        int index = 0;
        while (index < k && fast != null) {
            fast = fast.next;
            index++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
