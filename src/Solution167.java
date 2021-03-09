import java.util.Arrays;

public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum > target) right--;
            else left++;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution167 solu = new Solution167();
        int[] test = {2,7,11,15};
        System.out.println(Arrays.toString(solu.twoSum(test, 9)));
    }

}
