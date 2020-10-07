import java.util.Arrays;

public class Solution75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int end0 = 0, end1 = 0;
        for(int i = 0; i < nums.length; i++){
            switch(nums[i]){
                case 2:
                    break;
                case 1:
                    if(end1 != i)nums[i] = 2;
                    nums[end1++] = 1;
                    break;
                case 0:
                    if(end1 != i){
                        nums[i] = 2;
                    }
                    if(end0 == end1) {
                        end1++;
                    }else{
                        nums[end1++] = 1;
                    }
                    nums[end0++] = 0;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Solution75 solu = new Solution75();
        solu.sortColors(new int[]{2,0,2,1,1,0});
    }

}
