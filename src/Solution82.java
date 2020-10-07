public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        boolean flag = true;
        ListNode cur = head, pre = head;
        while(cur != null){
            while(cur != null && cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val)cur = cur.next;
                cur = cur.next;
            }
            if(flag){
                flag = false;
                head = cur;
                pre = cur;
            }else{
                pre.next = cur;
                pre = pre.next;
            }
            if(cur != null) cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(4);
//        cur = cur.next;
//        cur.next = new ListNode(5);

        Solution82 solu = new Solution82();
        solu.deleteDuplicates(head);
    }

}
