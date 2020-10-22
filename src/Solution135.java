import java.util.*;

public class Solution135 {

    public int candy(int[] ratings) {
        int[] can = new int[ratings.length];
        Arrays.fill(can, 1);
        boolean flag = true;
        int min;
        while (flag) {
            flag = false;
            for (int i = 0; i < can.length; i++) {
                min = -1;
                if (i > 0 && ratings[i - 1] < ratings[i] && can[i - 1] >= can[i]) min = can[i - 1] + 1;
                if (i < can.length - 1 && ratings[i + 1] < ratings[i] && can[i + 1] >= can[i]) min = Math.max(min, can[i + 1] + 1);
                if (min != -1) {
                    flag = true;
                    can[i] = min;
                }
            }
        }
        int sum = 0;
        for (int value : can) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {1,2,2};
        System.out.println(new Solution135().candy(test));
    }

}
