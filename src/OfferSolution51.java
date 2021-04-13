public class OfferSolution51 {

    public int reversePairs(int[] nums) {
        final int n = nums.length;
        int[] copy = new int[n], temp = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        return mergeSort(copy, 0, n - 1, temp);
    }

    public int mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int leftCount = mergeSort(nums, left, mid, temp);
        int rightCount = mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) return leftCount + rightCount;
        int leftIndex = left, rightIndex = mid + 1;
        int count = 0;
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        for (int i = left; i <= right; i++) {
            if (leftIndex > mid) {
                nums[i] = temp[rightIndex++];
            } else if(rightIndex > right) {
                nums[i] = temp[leftIndex++];
            } else if (temp[leftIndex] <= temp[rightIndex]) {
                nums[i] = temp[leftIndex++];
            } else {
                nums[i] = temp[rightIndex++];
                count += mid - leftIndex + 1;
            }
        }
        return leftCount + rightCount + count;
    }

    public static void main(String[] args) {
        OfferSolution51 solu = new OfferSolution51();
        int[] test = {5, 4, 3, 2, 1};
        System.out.println(solu.reversePairs(test));
    }

}
