import java.util.*;
public class Solution1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->{return b - a;});
        for (int i : stones) que.offer(i);
        while(que.size() >= 2) {
            int first = que.poll();
            int second = que.poll();
            int temp = first - second;
            if (temp > 0) que.offer(temp);
            else if (temp < 0) que.offer(-temp);
        }
        return que.size() > 0 ? que.poll() : 0;
    }

}
