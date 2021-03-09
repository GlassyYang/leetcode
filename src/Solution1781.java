import java.util.*;

public class Solution1781 {
    // 超时了
    public int beautySumChaoShi(String s) {
        int n = s.length();
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                // 计算s[i][j]的美丽值
                char c = s.charAt(j);
                if (map.containsKey(c))map.put(c, map.get(c) + 1);
                else map.put(c, 1);
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (char key : map.keySet()) {
                    int value = map.get(key);
                    if (min > value) min = value;
                    if (max < value) max = value;
                }
                sum += max - min;
            }
        }
        return sum;
    }

    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0;i < s.length();++i) {
            int[] count = new int[26];
            for (int j = i;j < s.length();++j) {
                char ch = s.charAt(j);
                count[ch - 'a'] += 1;
                int max_value = Integer.MIN_VALUE;
                int min_value = Integer.MAX_VALUE;
                for (int value: count) {
                    if (value > 0 && value > max_value) {
                        max_value = value;
                    }
                    if (value > 0 && value < min_value) {
                        min_value = value;
                    }
                }
                ans += (max_value - min_value);
            }
        }
        return ans;
    }

}
