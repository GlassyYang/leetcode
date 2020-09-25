import java.util.Arrays;

public class Solution25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, newHead = null;
        ListNode[] buf = new ListNode[k];
        ListNode last = null;
        Arrays.fill(buf, null);
        while(true){
            for(int i = 0; i < k; i++){
                if(cur == null)
                    break;
                buf[i] = cur;
                cur = cur.next;
            }
            if(buf[k - 1] == null && cur == null){
                break;
            }
            buf[0].next = buf[k - 1].next;
            if(newHead == null)
                newHead = buf[k - 1];
            if(last!= null) last.next = buf[k - 1];
            for(int i = k - 1; i > 0; i--){
                buf[i].next = buf[i-1];
            }
            last = buf[0];
            buf[k - 1] = null;
        }
        return newHead == null ? head : newHead;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1), cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        ListNode ans = reverseKGroup(head, 3);
        while(ans != null){
            System.out.println(ans.val);
            ans =ans.next;
        }
    }

}
