import java.util.Arrays;

public class Solution650 {

    public int minSteps(final int n) {
        int[] steps = new int[n +1 ];
        Arrays.fill(steps, 3000);
        steps[1] = 0;
        for (int i = 1; i <= n; i++) {
            if(i + 1 <= n) steps[i + 1] = Math.min(steps[i] + 1, steps[i + 1]);
            if (i << 1 <= n) steps[i << 1] = Math.min(steps[i] + 1, steps[i << 1]);
        }
        return steps[n];
    }

    public static void main(String[] args) {
        Solution650 solution650 = new Solution650();
        System.out.println(solution650.minSteps(3));
    }

}
