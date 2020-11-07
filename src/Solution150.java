import java.util.*;

public class Solution150 {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> sta = new Stack<>();
        int left, right;
        for (String e: tokens) {
            switch (e) {
                case "+":
                    right = sta.pop();
                    left = sta.pop();
                    sta.push(left + right);
                    break;
                case "-":
                    right = sta.pop();
                    left = sta.pop();
                    sta.push(left - right);
                    break;
                case "*":
                    right = sta.pop();
                    left = sta.pop();
                    sta.push(left * right);
                    break;
                case "/":
                    right = sta.pop();
                    left = sta.pop();
                    sta.push(left / right);
                    break;
                default:
                    sta.push(Integer.parseInt(e));
                    break;
            }
        }
        return sta.pop();
    }

}
