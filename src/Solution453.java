import java.util.*;
import java.util.stream.IntStream;

public class Solution453 {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt(), sum = Arrays.stream(nums).sum();
        return nums.length != 1 ? sum - nums.length * min : 0;
    }
}
