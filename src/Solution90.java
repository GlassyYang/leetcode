import java.util.*;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Stack<Integer> sta = new Stack<>();
        if (nums.length == 0) return ans;
        else if (nums.length < 2) {
            sta.push(nums[0]);
            ans.add(new ArrayList<>(sta));
            return ans;
        }
        Arrays.sort(nums);
        recusive(nums, 0, sta, ans);
        return ans;
    }

    public void recusive(int[] nums, int index, Stack<Integer> cur, List<List<Integer>> ans) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            cur.push(nums[i]);
            ans.add(new ArrayList<>(cur));
            recusive(nums, i + 1, cur, ans);
            cur.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        Solution90 solu = new Solution90();
        List<List<Integer>> ans = solu.subsetsWithDup(nums);
        System.out.println("finished");
    }

}
