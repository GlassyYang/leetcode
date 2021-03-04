import java.util.*;

public class Solution354 {

    public int maxEnvelopes(int[][] envelopes) {
        List<Integer> test = new ArrayList<>();
        int n = envelopes.length;
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}
