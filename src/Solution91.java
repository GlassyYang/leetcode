import java.util.*;

public class Solution91 {

    public int numDecodings(String s) {
        if(s == null) return -1;
        if(s.length() == 0)return 0;
        if(s.charAt(0) == '0') return 0;
//        return recusiveSearch(s, 0);
        int[] f = new int[s.length() + 1];
        int temp = 0, j = 0, count = 0;
        Arrays.fill(f, 0);
        f[f.length - 1] = 1;
        f[f.length - 2] = s.charAt(f.length - 2) == '0' ? 0 : 1;
        for(int i = f.length - 3; i >= 0; i--){
            if(s.charAt(i) =='0'){
                f[i] = 0;
            }else {
                temp = 0;
                j = i + 1;
                count = 0;
                while(j < f.length){
                    temp *= 10;
                    temp += s.charAt(j - 1) - '0';
                    if(temp > 26)
                        break;
                    count += f[j];
                    j++;
                }
                f[i] = count;
            }
        }
        return f[0];
    }
    // 试试动态规划
    public int recusiveSearch(String s, int i){
        if(i >= s.length()) return 1;
        int temp = 0, count = 0;
        while(i < s.length()){
            temp *= 10;
            temp += s.charAt(i) - '0';
            i++;
            if(temp > 26 || temp == 0)
                break;
            count += recusiveSearch(s, i);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution91 solu = new Solution91();
        System.out.println(solu.numDecodings("10"));
    }

}
