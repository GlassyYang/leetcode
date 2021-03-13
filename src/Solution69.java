public class Solution69 {

    // 牛顿法求一个数的平方根
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }

    // 替换算法
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        double exp = Math.log(x) * 0.5;
        int ans = (int)Math.exp(exp);
        return (ans + 1 ) * (ans + 1) <= x ? ans + 1 : ans;
    }

}
