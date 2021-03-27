import java.util.*;

public class Solution682 {

    public int calPoints(String[] ops) {
        int[] buf = new int[ops.length];
        int index = -1;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    buf[index + 1] = buf[index] + buf[index - 1];
                    index++;
                    break;
                case "D":
                    buf[index + 1] = buf[index] << 1;
                    index++;
                    break;
                case "C":
                    index--;
                    break;
                default:
                    buf[++index] = Integer.parseInt(ops[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i <= index; i++) {
            ans += buf[i];
        }
        return ans;
    }

}
