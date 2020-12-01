import java.util.*;

public class Solution164 {

    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max= Arrays.stream(nums).max().getAsInt();
        int min= Arrays.stream(nums).min().getAsInt();
        if (max == min) return 0;// 最大和最小相等，间距直接返回0
        int bucketSize= (int)Math.ceil(1.0*(max-min) / (nums.length-1));//向上取整
        int bucketCount=( max - min) / bucketSize +1;
        int[][] buckets=new int[bucketCount][];

        for (int i = 0; i < nums.length; i++) {// 利用映射函数将数据分配到各个桶中
            int index= (nums[i]-min) /bucketSize;
            if(buckets[index]==null) buckets[index]=new int[]{nums[i],nums[i]};
            else{//只维护桶内最大最小值
                if(nums[i]<buckets[index][0]) buckets[index][0]=nums[i];
                if(nums[i]>buckets[index][1]) buckets[index][1]=nums[i];
            }
        }

        int maxDis = 0 ,last = -1;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i] == null) continue;
            if (last != -1) {
                maxDis = Math.max(maxDis, buckets[i][0] - buckets[last][1]);
            }
            last = i;
        }
        return maxDis;
    }

}
