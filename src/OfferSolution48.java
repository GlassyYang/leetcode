import java.util.*;

public class OfferSolution48 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        final int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int cCount = map.getOrDefault(c, 0);
            map.put(c, cCount + 1);
            if (cCount == 0) {
                count++;
            } else {
                char countC = s.charAt(i - count);
                map.put(countC, map.get(countC) - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Stack<Integer> sta = new Stack<>();
        StringBuilder builder = new StringBuilder();
//        builder.deleteCharAt()
        builder.length();
        OfferSolution48 solu = new OfferSolution48();
        System.out.println(solu.lengthOfLongestSubstring("pwwkew"));
    }

}
