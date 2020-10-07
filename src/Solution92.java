import java.util.Stack;

public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        if(m == n) return  head;
        ListNode mNode = head, nNode = null, cur = head, fail = null;
        boolean flag = m == 1;
        int count = 1;
        Stack<ListNode> sta = new Stack<>();
        while(cur != null){
            count++;
            if(flag) sta.push(cur);
            if(count == m) {
                mNode = cur;
                flag = true;
            }
            else if(count == n + 1){
                nNode = cur.next;
                flag = false;
                break;
            }
            cur = cur.next;
        }
        cur = sta.pop();
        if(m != 1){
            mNode.next = cur;
        }else{
            head = cur;
        }
        while(!sta.isEmpty()){
            cur.next = sta.peek();
            cur = sta.pop();
        }
        cur.next = nNode;
        return head;
    }

    public static void main(String[] args) {
        Solution92 solu = new Solution92();
        ListNode head = new ListNode(1), cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        solu.reverseBetween(head, 1, 4);
    }
}
