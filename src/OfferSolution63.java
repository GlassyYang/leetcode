import java.util.*;

public class OfferSolution63 {

    // 单调栈
    public int maxProfit(int[] prices) {
        Deque<Integer> sta = new LinkedList<>();
        int max = 0;
        for (int i : prices) {
            while (!sta.isEmpty() && i < sta.peekLast()) sta.pollLast();
            sta.offerLast(i);
            int curMax = i - sta.peekFirst();
            if (curMax > max) max = curMax;
        }
        return max;
    }

}
