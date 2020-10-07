import java.util.*;

public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(k > n || k == 0 || n == 0) return ans;
        Stack<Integer> sta = new Stack<>();
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, false);
        reverse(sta, flags, k, ans, -1);
        return ans;
    }

    public void reverse(Stack<Integer> sta, boolean[] flags, int k, List<List<Integer>> ans, int index){
        if(sta.size() == k){
            List<Integer> one = new ArrayList<>(k);
            one.addAll(sta);
            ans.add(one);
        }else{
            for(int i = index+1; i < flags.length; i++){
                if(!flags[i]){
                    sta.push(i + 1);
                    flags[i] = true;
                    reverse(sta, flags, k, ans, i);
                    sta.pop();
                    flags[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution77 solu = new Solution77();
        List<List<Integer>> ans = solu.combine(4, 2);
        System.out.println(ans);
    }
}
