import java.util.*;

public class Solution842 {

    public List<Integer> splitIntoFibonacci2(String S) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        char lprec = 'a';
        for(int i = 0; i < S.length(); i++){
            if(lprec == '0') break;

            recusive(S, 0, ans);
        }
        return ans;
    }

    private int recusive(String S, int index, List<Integer> ans){
        int left = ans.get(ans.size() - 1), right = 0, sum = 0;
        char rprec = 'a', sprec = 'b';
        for(int i = index; i < S.length(); i++){
            if(rprec == '0') break;
            rprec = S.charAt(i);
            right *= 10;
            right += rprec - '0';
            sprec = 'a';
            int j = i + 1;
            while(left + right > sum && j < S.length()){
                if(sprec == '0') break;
                sprec = S.charAt(j);
                sum *= 10;
                sum += sprec - '0';
                j++;
            }
            if(left + right == sum) {
                ans.add(right);
                ans.add(sum);
                if( j >= S.length()) return S.length();
                int result = recusive(S, j + 1, ans);
                if(result >= S.length()) {
                    return result;
                } else {
                    ans.remove(ans.size() - 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
        return -1;
    }


    private int recusive2(String S, int index, List<Integer> ans){
        int left = 0, right = 0, sum = 0;
        char lprec = 'a', rprec = 'a', sprec = 'a';
        for (int i = index; i < S.length(); i++) {
            if(lprec == '0') break;
            lprec = S.charAt(i);
            left *= 10;
            left += lprec - '0';
            right = 0;
            rprec = 'a';
            for(int j = i + 1; j < S.length(); j++) {
                if(rprec == '0') break;
                rprec = S.charAt(j);
                right *= 10;
                right += rprec - '0';
                sum = 0;
                sprec = 'a';
                int k = j + 1;
                while (left + right > sum && k < S.length()) {
                    if(sprec == '0') break;
                    sprec = S.charAt(k);
                    sum *= 10;
                    sum += sprec - '0';
                    k++;
                }
                if(left + right == sum) {
                    ans.add(left);
                    ans.add(right);
                    ans.add(sum);
                    if( k >= S.length()) return S.length();
                    int result = recusive(S, k + 1, ans);
                    if(result >= S.length()) {
                        return result;
                    } else {
                        ans.remove(ans.size() - 1);
                        ans.remove(ans.size() - 1);
                        ans.remove(ans.size() - 1);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "112358130";
        Solution842 solu = new Solution842();
//        System.out.println(solu.splitIntoFibonacci(s));
    }

}
