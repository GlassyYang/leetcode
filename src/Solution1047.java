import java.util.*;

public class Solution1047 {

    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) return S;
        Stack<Character> sta = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!sta.isEmpty() && sta.peek() == S.charAt(i)) {
                sta.pop();
            } else {
                sta.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        Iterator<Character> iter = sta.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1047 solu = new Solution1047();
        System.out.println(solu.removeDuplicates("abbacbaabca"));
    }

}
