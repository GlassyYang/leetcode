import java.util.*;

public class OffSolution10II {

    public int numWays(int n) {
        if (n == 0) return 1;
        if (n < 3) return n;
        int pre2 = 1, pre = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = (pre + pre2) % 1000000007 ;
            pre2 = pre;
            pre = temp;
        }
        return pre;
    }

}
