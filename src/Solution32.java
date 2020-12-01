import java.util.*;

public class Solution32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> sta = new Stack<>();
        sta.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') sta.push(i);
            else{
                sta.pop();
                if (sta.empty()) {
                    sta.push(i);
                } else {
                    max = Math.max(max, i - sta.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution32 solu = new Solution32();
//        String test = "())((())";
        String test = ")()())";
        System.out.println(solu.longestValidParentheses(test));
    }

}
