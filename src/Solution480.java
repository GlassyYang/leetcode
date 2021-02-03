import java.util.*;

public class Solution480 {


    // 利用有序集合（java中是TreeSet)做这道题
    public double[] medianSlidingWindow(int[] nums, int k) {
        boolean flag = k % 2 == 1;
        int left = (k + 1) / 2;
        // 这儿的比较函数需要特别注意，应该使用Integer自带的比较函数加符号，直接使用减法作比较的话会造成溢出
        PriorityQueue<Integer> leftQue = new PriorityQueue<>((a, b)-> -Integer.compare(a, b));
        PriorityQueue<Integer> rightQue = new PriorityQueue<>();
        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) rightQue.offer(nums[i]);
        for (int i = 0; i < left; i++) leftQue.offer(rightQue.poll());
        for (int i = 0; i < ans.length; i++) {
            ans[i] = flag ? leftQue.peek() : ((double)leftQue.peek() + rightQue.peek()) / 2;
            if (i + k >= nums.length) break;
            if (nums[i + k] <= leftQue.peek()) leftQue.offer(nums[i + k]);
            else rightQue.offer(nums[i + k]);
            if (nums[i] > leftQue.peek()) rightQue.remove(nums[i]);
            else leftQue.remove(nums[i]);
            while (leftQue.size() < left) leftQue.offer(rightQue.poll());
            while (leftQue.size() > left) rightQue.offer(leftQue.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution480 solu = new Solution480();
        int[] test = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solu.medianSlidingWindow(test, 3)));
    }

}
