import java.util.*;

public class Solution1513 {

    public int numSub(String s) {
        long ans = 0;
        int count1 = 0;
        final long mod = 1000000007;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count1++;
            else if (count1 > 0) {
                long temp;
                if (map.containsKey(count1)) {
                    temp = map.get(count1);
                }
                else {
                    temp = (count1 % mod) * ((count1 + 1) % mod) / 2;
                    map.put(count1, temp);
                }
                ans += temp;
                ans %= mod;
                count1 = 0;
            }
        }
        if (count1 > 0) {
            long temp;
            if (map.containsKey(count1)) temp = map.get(count1);
            else temp = (count1 % mod) * ((count1 + 1) % mod) / 2;
            ans += temp;
            ans %= mod;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        String test = "0110111";
        Solution1513 solu = new Solution1513();
        System.out.println(solu.numSub(test));
    }


}
