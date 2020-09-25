public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans =  new ListNode(), cur = ans;
        while(true){
            if(l1 != null && l2 != null){
                cur.next = new ListNode();
                cur = cur.next;
                if(l1.val < l2.val){
                    cur.val = l1.val;
                    l1 = l1.next;
                }else{
                    cur.val = l2.val;
                    l2 = l2.next;
                }
            }else if(l1 != null){
                cur.next = new ListNode();
                cur = cur.next;
                cur.val = l1.val;
                l1 = l1.next;
            }else if(l2 != null){
                cur.next = new ListNode();
                cur = cur.next;
                cur.val = l2.val;
                l2 = l2.next;
            }else{
                break;
            }
        }
        ans = ans.next;
        return ans;
    }

}
