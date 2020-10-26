public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode insert = head;
        ListNode cur, prev, temp;
        while(insert.next != null){
            temp = insert.next;
            insert.next = temp.next;
            if(temp.val < head.val){
                temp.next = head;
                head = temp;
                continue;
            }
            cur = head;
            prev = head;
            while(cur != insert.next){
                System.out.println(cur.val);
                if(cur.val > temp.val) break;
                prev = cur;
                cur = cur.next;
            }
            prev.next = temp;
            temp.next = cur;
            if(temp == insert.next) insert = insert.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        Solution147 solu = new Solution147();
        head = solu.insertionSortList(head);
        System.out.println(head);
    }

}
