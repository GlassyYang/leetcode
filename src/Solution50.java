/*
 * 快速幂算法，计算pow(x, n)的快捷算法，时间复杂度O(log(n))
 */
import java.util.*;
public class Solution50 {

    public double myPow(double x, int n) {
        long N = (n >= 0 ? n : -n);
        // return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        long mask = 1;
        double ans = 1;
        double temp = 0;
        // 来个快速幂的迭代版, 加上位运算
        while(N > 0){
            temp = ((mask & N) == 0) ? ans * ans : ans * ans * x;
            ans = temp;
            N >>= 2;
        }
        return ans;
    }

    public double quickMul(double x, long N) {
        if(N == 0) return 1.0;
        if(N == 1) return x;
        long half = N / 2;
        double ans = quickMul(x, half);
        ans = (N % 2) == 0 ? (ans * ans) : (ans * ans * x);
        return N > 0 ? ans : 1.0 / ans;
    }

    public static void main(String[] args) {
        Solution50 solu = new Solution50();
        System.out.println(solu.myPow(1e-6, Integer.MAX_VALUE));

    }

}
