import java.util.*;

public class OfferSolution06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> sta = new Stack<>();
        while (head != null) {
            sta.push(head.val);
            head = head.next;
        }
        int[] ans = new int[sta.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = sta.pop();
        }
        return ans;
    }

}
