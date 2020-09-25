import java.util.*;

public class Solution17 {

    public static List<String> letterCombinations(String digits) {
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Stack<Character> sta = new Stack<>();
        int[] num = new int[digits.length()];
        StringBuilder builder = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            num[i] = digits.charAt(i) - '2';
        }
        int[] index = new int[digits.length()];
        Arrays.fill(index, 0);
        //树搜索
        while (true) {
            int curIndex = sta.size();
            while (curIndex < digits.length()) {
                sta.push(map[num[curIndex]].charAt(index[curIndex]));
                curIndex += 1;
            }
            curIndex = digits.length() - 1;
            for (char e : sta) {
                builder.append(e);
            }
            ans.add(builder.toString());
            builder.setLength(0);
            index[curIndex] += 1;
            while(curIndex >= 0){
                if(index[curIndex] >= map[num[curIndex]].length()){
                    index[curIndex] = 0;
                    curIndex--;
                    if(curIndex >= 0)
                        index[curIndex]++;
                    sta.pop();
                }else{
                    break;
                }
            }
            if(curIndex < 0)
                break;
            sta.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
