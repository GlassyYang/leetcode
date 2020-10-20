import java.lang.reflect.Array;
import java.util.*;

public class Solution131 {
    //BFS加栈
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        if(s == null || s.length() == 0) return ans;
        Stack<String> sta = new Stack<>();
        recusive(s, 0, sta, ans);
        return ans;
    }
    public void recusive(String s, int index, Stack<String> sta, List<List<String>> ans){
        if(index >= s.length()) ans.add(new ArrayList<>(sta));
        int begin, end;
        boolean flag = true;
        for(int i = index; i < s.length(); i++){
            // 验证s[index:i]是不是一个回文字符串
            begin = index;
            end = i;
            flag = true;
            for(; begin <= end; begin++, end--)
                if(s.charAt(begin) != s.charAt(end)){
                    flag = false;
                    break;
                }
            if(flag){
                begin = index;
                end = i;
                sta.push(s.substring(begin, end + 1));
                recusive(s, end + 1, sta, ans);
                sta.pop();
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        Solution131 solu = new Solution131();
        System.out.println(solu.partition(str));
    }

}
