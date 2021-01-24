import java.util.*;

public class Solution1686 {

    class Pair {
        int alice;
        int bob;
        public Pair(int alice, int bob) {
            this.alice = alice;
            this.bob = bob;
        }
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.alice + b.bob - a.alice - a.bob);
        for (int i = 0; i < aliceValues.length; i++) {
            queue.add(new Pair(aliceValues[i], bobValues[i]));
        }
        int sumAlice = 0, sumBob = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (flag)
                sumAlice += temp.alice;
            else
                sumBob += temp.bob;
            flag = !flag;
        }
        if (sumAlice > sumBob) return 1;
        else if (sumAlice < sumBob) return -1;
        return 0;
    }
}
