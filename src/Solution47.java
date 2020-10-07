import java.util.*;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        Arrays.fill(flags, false);
        Stack<Integer> sta = new Stack<>();
        recusive(flags, nums, sta, ans);
        return ans;
    }

    public void recusive(boolean[] flags, int[] nums, Stack<Integer> sta, List<List<Integer>> ans){
        boolean flag = false;
        for(int i = 0; i < flags.length; i++){
            if(flags[i] == false){
                flag = true;
                flags[i] = true;
                sta.push(nums[i]);
                recusive(flags, nums, sta, ans);
                sta.pop();
                flags[i] = false;
            }
        }
        if(flag == false){
            ans.add(new ArrayList<>(sta));
        }
    }

    public static void main(String[] args) {
        int[] temp1 = {1,2,3}, temp2 = {1,2,3};
        Set<int[]> set = new HashSet<int[]>();
        set.add(temp1);
        set.add(temp2);
        System.out.println(set.size());
        System.out.println(Arrays.equals(temp1, temp2));
    }

}
