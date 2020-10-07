import java.util.*;

public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        // 位运算
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        List<Integer> one;
        boolean flag = false;
        boolean[] flags = new boolean[nums.length];
        Arrays.fill(flags, false);
        while(!flag){
            if(flags[flags.length - 1]){
                flags[flags.length - 1] = false;
                flag = true;
            }else{
                flags[flags.length - 1] = true;
            }
            for(int i = flags.length - 2; i >= 0; i--){
                if(flag && flags[i]){
                    flags[i] = false;
                }else if(flag && !flags[i]){
                    flag = false;
                    flags[i] = true;
                }else{
                    break;
                }
            }
            one = new ArrayList<>();
            for(int i = 0; i < flags.length; i++){
                if(flags[i]) one.add(nums[i]);
            }
            ans.add(one);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution78 solu = new Solution78();
        solu.subsets(new int[]{1,2});
    }
}
