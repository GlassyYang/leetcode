public class OfferSolution21 {

    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        int n = nums.length / 2;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) left++;
            while (left < right && (nums[right] & 1) == 0) right--;
            if (left < right) {
                System.out.printf("%d, %d\n", nums[left], nums[right]);
                nums[left] += nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] = nums[left] - nums[right];
                left++;
                right--;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        OfferSolution21 solu = new OfferSolution21();
        int[] test = {2,4,1,3};
        System.out.println(solu.exchange(test));
    }

}
