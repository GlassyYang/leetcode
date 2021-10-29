import java.util.*;

public class Solution335 {

    class Solution {
        public boolean isSelfCrossing(int[] distance) {
            int n = distance.length;
            if (n < 4) return false;
            int i = 2;
            while (i < n && distance[i] > distance[i - 2]) i++;
            if (i == n) return false;
            if (distance[i] >= distance[i - 2] - (i < 4 ? 0 : distance[i - 4])) {
                distance[i - 1] -=  i < 3 ? 0 : distance[i - 3];
            }

            for (++i; i < n && distance[i] < distance[i - 2]; i++);

            return i != n;
        }
    }
    public static void main(String[] args) {

    }
}
