import java.util.*;

public class OfferSolution59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
        }
        for (int i = 0; i < ans.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i + k - 1]) deque.pollLast();
            deque.offerLast(i + k - 1);
            int maxI = deque.peekFirst();
            while (maxI < i) {
                deque.pollFirst();
                maxI = deque.peekFirst();
            }
            ans[i] = nums[maxI];
        }
        return ans;
    }

}
