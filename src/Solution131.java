import java.lang.reflect.Array;
import java.util.*;

public class Solution131 {
    //BFS加栈
    public List<List<String>> partition2(String s) {
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

    // 用动态规划加深度优先搜索加回溯的方法做这道题
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        if(s == null || s.length() == 0) return ans;
        // 首先动态规划预处理确定所有的回文子序列
        final int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i > 0) dp[i][i - 1] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        Stack<Integer> index = new Stack<>();
        index.push(0);
        while (!index.isEmpty()) {
            int start = index.peek(),end = start;
            boolean found = false;
            if (start >= n) {
                // 这是一个答案
                Iterator<Integer> iter = index.iterator();
                int pre = iter.next();
                List<String> one = new ArrayList<>();
                while (iter.hasNext()) {
                    int next = iter.next();
                    one.add(s.substring(pre, next));
                    pre = next;
                }
                ans.add(one);
                index.pop();
            }
            while (end < n) {
                if (dp[start][end]) {
                    found = true;
                    break;
                }
                end++;
            }
            while (!found && start >= 0) {
                end = index.pop();
                if (index.isEmpty()) break;
                start = index.peek();
                while (end < n) {
                    if (dp[start][end]) {
                        found = true;
                        break;
                    }
                    end++;
                }
            }
            if (found) index.push(end + 1);
            }
        return ans;
    }

    public static void main(String[] args) {
        String str = "";
        Solution131 solu = new Solution131();
        System.out.println(solu.partition(str));
    }

}
