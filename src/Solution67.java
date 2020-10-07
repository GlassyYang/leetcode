import java.util.*;

public class Solution67 {

    public String addBinary(String a, String b) {
        Stack<Character> add = new Stack<>();
        String max = a.length() > b.length() ? a : b;
        String min = max == a ? b : a;
        int index = 1;
        boolean flag = false;
        int minL = min.length(), maxL = max.length();
        int ans;
        while(index <= minL){
            ans = (min.charAt(minL - index) - '0') + (max.charAt(maxL - index) - '0') + (flag ? 1 : 0);
            if(ans == 2){
                ans = 0;
                flag = true;
            }
            add.push((char)(ans + '0'));
            if(!flag) break;
            index += 1;
        }
        while(index <= maxL){
            ans = (max.charAt(maxL - index++) - '0') + (flag ? 1 : 0);
            if(ans == 2){
                ans = 0;
                flag = true;
            }
            add.push((char)(ans + '0'));
        }
        if(flag) add.push('1');
        StringBuilder builder = new StringBuilder();
        while(!add.isEmpty()) builder.append(add.pop());
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution67 solu = new Solution67();
        System.out.println(solu.addBinary("11", ""));
    }

}
