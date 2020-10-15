import java.util.*;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n <= 0) return ans;
        Stack<Character> sta = new Stack<>();
        StringBuilder builder = new StringBuilder();
        recusive(sta, n, n, ans);
        return ans;
    }

    private void recusive(Stack<Character> sta, int preNum, int sufNum, List<String> ans){
        if(preNum == 0 && sufNum == 0){
            StringBuilder builder = new StringBuilder();
            for(char e : sta){
                builder.append(e);
            }
            ans.add(builder.toString());
            return;
        }
        if(preNum > 0 && preNum <= sufNum){
            sta.push('(');
            recusive(sta, preNum - 1, sufNum, ans);
            sta.pop();
        }
        if(sufNum > 0){
            sta.push(')');
            recusive(sta, preNum, sufNum - 1, ans);
            sta.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }

}
