import java.util.*;

public class Solution1207 {

    public boolean uniqueOccurrences(int[] arr) {
        if(arr == null || arr.length == 0) return true;
        int[] buf = new int[2001];
        for (int e : arr) {
            buf[e + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for(int e : buf){
            if(e != 0){
                if(set.contains(e)) return false;
                else set.add(e);
            }
        }
        return true;
    }

}
