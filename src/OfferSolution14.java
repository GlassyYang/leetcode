public class OfferSolution14 {
    // 剪绳子
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        // 利用快速幂算法解决这个问题
        int numberOfThree = n / 3, numberOfTwo = n % 3;
        if (numberOfTwo > 0) {
            if (numberOfTwo == 1) {
                numberOfTwo++;
                numberOfThree--;
            } else {
                numberOfTwo--;
            }
        }
        int ans = 1, mask = 1;
        long exp3 = 3;
        final int mod = 1000000007;
        while (numberOfThree > 0) {
            if ((numberOfThree & mask) > 0) {
                numberOfThree &= numberOfThree - 1;
                ans = (int) ((ans * exp3) % mod);
            }
            mask <<= 1;
            exp3 *= exp3;
            exp3 %= mod;
        }
        if (numberOfTwo > 0) {
            numberOfTwo <<= 1;
            ans = (int) (((long)ans * numberOfTwo) % mod);
        }
        return ans;
    }

    public static void main(String[] args) {
        OfferSolution14 solu = new OfferSolution14();
        System.out.println(solu.cuttingRope(5));
    }

}
