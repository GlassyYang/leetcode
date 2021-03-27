public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = nums[end];
            int index = start;
            for (int i = start; i < end; i++) {
                if (nums[i] <= mid) {
                    int temp = nums[index];
                    nums[index++] = nums[i];
                    nums[i] = temp;
                }
            }
            int temp = nums[index];
            nums[index] = nums[end];
            nums[end] = temp;
            int big = end - index + 1;
            if (big < k) {
                k -= big;
                end = index - 1;
            } else if (big == k){
                return mid;
            }else {
                start = index + 1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] test = {2,5,3,4,1,6,4,7,9,3,5};
        Solution215 solu = new Solution215();
        for (int i = 0; i < test.length; i++) {
            System.out.println(solu.findKthLargest(test, i + 1));
        }
    }

}
