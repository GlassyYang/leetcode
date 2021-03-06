import java.util.*;

public class Solution503 {
    // 理解错了题意
    public int[] nextGreaterElementsA(int[] nums) {
        //二分搜索改版
        if (nums.length == 0) return nums;
        int[] ans = new int[nums.length];
        int index = 0, cur = nums[0];
        boolean begin = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) continue;
            if (nums[i] > cur) {
                while (index < i) ans[index++] = nums[i];
            } else {
                while (index < i) ans[index++] = -1;
                begin = true;
            }
            cur = nums[i];
        }
        int next = begin? (cur != nums[0] ? nums[0] : ans[0]) : -1;
        if (index == 0) ans[index++] = -1;
        while(index < ans.length) {
            ans[index++] = next;
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution503 solu = new Solution503();
        int[] test = {1,2,1};
//        int[] test = {1,1,1};
        System.out.println(Arrays.toString(solu.nextGreaterElements(test)));
    }

}
