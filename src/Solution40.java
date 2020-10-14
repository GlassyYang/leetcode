import java.util.*;

public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates.length == 0) return ans;
        Arrays.sort(candidates);
        recusive(candidates, 0, target, 0, new Stack<Integer>(), ans);
        return ans;
    }

    public void recusive(int[] nums, int index, int target, int sum, Stack<Integer> cur, List<List<Integer>> ans) {
        if (index >= nums.length || nums[index] + sum > target) return;
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            if (nums[i] + sum > target) break;
            else if(nums[i] + sum == target){
                cur.push(nums[i]);
                ans.add(new ArrayList<>(cur));
                cur.pop();
            }else {
                sum += nums[i];
                cur.push(nums[i]);
                recusive(nums, i + 1, target, sum, cur, ans);
                sum -= nums[i];
                cur.pop();
            }
        }
    }

    public static void main(String[] args) {
        Solution40 solu = new Solution40();
        int[] test = {10,1,2,7,6,1,5};
        solu.combinationSum2(test, 8);
    }

}
