public class OfferSolution25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ans = new ListNode(), ansCur = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ansCur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                ansCur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ansCur = ansCur.next;
        }
        l1 = l1 == null ? l2 : l1;
        while (l1 != null) {
            ansCur.next = new ListNode(l1.val);
            l1 = l1.next;
            ansCur = ansCur.next;
        }
        return ans.next;
    }

}
