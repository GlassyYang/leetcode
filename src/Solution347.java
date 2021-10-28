import java.util.*;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> topKFrequencyNums = new PriorityQueue<>(Comparator.comparingInt(frequencies::get));
        int queueSize = 0;
        for(int num : frequencies.keySet()) {
            topKFrequencyNums.add(num);
            queueSize++;
            if(queueSize > k) {
                topKFrequencyNums.poll();
                queueSize--;
            }
        }
        int[] ans = new int[k];
        int index = 0;
        for(int num : topKFrequencyNums) {
            ans[index++] = num;
        }
        return ans;
    }

}
