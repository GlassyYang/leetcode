import java.util.*;

public class Solution264 {

    public int nthUglyNumber(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        int[] multi = {2, 3, 5};
        int count = 0;
        int ans = -1;
        while (count < n) {
            int num = set.pollFirst();
            count++;
            if (count == n) {
                ans = num;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next = num * multi[i];
                if (next > 0 ) set.add(next);
            }
        }
        return ans;
    }

}
