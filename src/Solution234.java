import java.util.*;

public class Solution234 {
    // 快慢指针解决该问题
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;
        ListNode reverse =null, temp;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }
        if(fast != null){
            fast = slow;
            slow = slow.next;
        }else{
            fast = null;
        }
        ListNode reverse_cp = reverse;
        boolean flag = true;
        for(; slow != null; reverse = reverse.next, slow = slow.next){
            if(slow.val != reverse.val){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        Solution234 solu = new Solution234();
        System.out.println(solu.isPalindrome(root));
        System.out.println("finished");
    }

}
