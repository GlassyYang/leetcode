public class Solution509 {

    public int fib(int n) {
        if(n == 0) return 0;
        if (n == 1) return 1;
        int prev = 0, cur = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }

}
