public class Solution80 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int index = 0;
        int count = 0;
        int cur = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == cur){
                count++;
            }else{
                nums[index++] = cur;
                if(count > 1) nums[index++] = cur;
                count = 1;
                cur = nums[i];
            }
        }
        if(nums[nums.length - 1] != nums[nums.length - 2]){
            nums[index++] = nums[nums.length - 1];
        }else{
            nums[index++] = nums[nums.length - 1];
            nums[index++] = nums[nums.length - 1];
        }
        return index;
    }

    public static void main(String[] args) {
        Solution80 solu = new Solution80();
        solu.removeDuplicates(new int[]{2,3});
    }

}
