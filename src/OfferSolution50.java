import java.util.*;

public class OfferSolution50 {
    public char firstUniqChar(String s) {
        char[] buf = new char[26];
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            buf[index]++;
            if (buf[index] == 1) que.offer(s.charAt(i));
        }
        while(!que.isEmpty()) {
            char c = que.poll();
            if (buf[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
