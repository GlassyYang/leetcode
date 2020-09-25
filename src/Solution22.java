import java.util.*;

public class Solution22 {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Stack<Character> sta = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int length = 2 * n;
        int[] num = {n, n};
        while(true){
            if(num[0] > 0 && num[0] <= num[1]){
                sta.push('(');
                num[0]--;
            }else if(num[1] > 0 && num[0] <= num[1]){
                sta.push(')');
                num[1]--;
            }else if(num[0] <= 0 && num[1] <= 0){
                builder.setLength(0);
                for(char e : sta){
                    builder.append(e);
                }
                ans.add(builder.toString());
                num[sta.pop() - '(']++;
            }else{
                while(!sta.empty() && (num[1] > num[0] || sta.peek() == ')')){
                    num[sta.peek() - '(']++;
                    sta.pop();
                }
                if(sta.empty()){
                    break;
                }else{
                    num[sta.peek() - '('] ++;
                    sta.pop();
                    sta.push(')');
                    num[1]--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
