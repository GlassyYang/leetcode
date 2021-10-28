public class Solution565 {

    private int maxSize;
    private int[] nums;
    private static final int MAX_NUMBER = Integer.MAX_VALUE;
    public void findSet(int index) {
        int count = 0;
        int start = index;
        do {
            int temp = nums[index];
            nums[index] = Integer.MAX_VALUE;
            index = temp;
            count++;
        } while (index != start);
        maxSize = Math.max(maxSize, count);
    }
    public int arrayNesting(int[] nums) {
        this.nums = nums;
        maxSize = 1;
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if(nums[i] != MAX_NUMBER) {
                findSet(i);
            }
        }
        return maxSize;
    }

}
