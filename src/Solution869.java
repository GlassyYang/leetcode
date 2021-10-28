import java.util.*;

public class Solution869 {

    private static Set<String> set;

    private static int[] buf;

    private static final int MAX_NUMBER = 1_000_000_000;


    static {
        set = new HashSet<>();
        buf = new int[10];
        int count = 1;
        while (count < MAX_NUMBER) {
            set.add(getSortedString(count));
            count <<= 1;
        }
    }

    public static String getSortedString(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            buf[num % 10]++;
            num /= 10;
        }
        for(int i = 0; i < buf.length; ++i) {
            while (buf[i] > 0) {
                builder.append(i);
                buf[i]--;
            }
        }
        return builder.toString();
    }

    public boolean reorderedPowerOf2(int n) {
        return set.contains(getSortedString(n));
    }
}
