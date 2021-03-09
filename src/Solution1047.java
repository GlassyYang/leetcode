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
        for (Character character : sta) {
            builder.append(character);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1047 solu = new Solution1047();
        System.out.println(solu.removeDuplicates("abbacbaabca"));
    }

}

class Solution {
    // 深入理解java字符串和String之间的转换
    public String removeDuplicates(String S) {
        int index = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
            } else {
                index++;
                chars[index] = chars[i];
            }
        }
        return String.copyValueOf(chars, 0, index + 1);
    }
}
