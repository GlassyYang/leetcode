import java.util.*;

public class Solution143 {

    public void reorderList(ListNode head) {
        if(head == null) return;
        Deque<ListNode> deq = new LinkedList<>();
        for(; head != null; head = head.next) deq.offerLast(head);
        head = deq.pollFirst();
        head.next = null;
        boolean flag = false;
        while(!deq.isEmpty()){
            if(flag){
                deq.peekFirst().next = null;
                head.next = deq.pollFirst();
                flag = false;
                head = head.next;
            }else{
                deq.peekLast().next = null;
                head.next = deq.pollLast();
                flag = true;
                head = head.next;
            }
        }
    }

}
