import java.util.*;

public class Solution1363 {

    public String largestMultipleOfThree(int[] digits) {
        int[] numberCount =  new int[10];
        int[] mod1 = {1,4,7}, mod2 = {2,5,8};
        int sum = 0;
        for (int digit : digits) {
            numberCount[digit]++;
            sum += digit;
        }
        int mod = sum % 3;
        if (mod == 1) {
            mod0(numberCount, mod1, mod2);
        } else if (mod == 2) {
            mod0(numberCount, mod2, mod1);
        }
        // 开始输出答案
        StringBuilder builder = new StringBuilder(digits.length);
        for (int i = 9  ; i > 0; i--) {
            while (numberCount[i] > 0) {
                builder.append((char)(0x30 + i));
                numberCount[i]--;
            }
        }
        if (builder.length() > 0) {
            while (numberCount[0] > 0) {
                builder.append('0');
                numberCount[0]--;
            }
        } else {
            if (numberCount[0] > 0) {
                builder.append('0');
            }
        }
        return builder.toString();
    }

    private void mod0(int[] numberCount, int[] first, int[] second) {
        boolean flag = true;
        for (int j : first) {
            if (numberCount[j] > 0) {
                numberCount[j]--;
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < 2; i++) {
                for (int k : second) {
                    if (numberCount[k] > 0) {
                        numberCount[k]--;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1363 solu = new Solution1363();
        int[] test = {8,6,7,1,0};
        System.out.println(solu.largestMultipleOfThree(test));
    }

}
