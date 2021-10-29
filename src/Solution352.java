import java.util.*;

class SummaryRanges {

    private TreeMap<Integer, Integer> map = new TreeMap<>();


    public void addNum(int val) {
        if(map.containsKey(val)) {
            return;
        }
        Integer lowerKey = map.lowerKey(val), ceilingKey = map.ceilingKey(val);
        if(lowerKey != null) {
            int endBound = map.get(lowerKey);
            if(endBound < val - 1) {
                if (ceilingKey != null && ceilingKey == val + 1) {
                    map.put(val, map.get(ceilingKey));
                    map.remove(ceilingKey);
                } else {
                    map.put(val, val);
                }
            } else if (endBound == val - 1) {
                if (ceilingKey != null && ceilingKey == val + 1) {
                    map.put(lowerKey, map.get(ceilingKey));
                    map.remove(ceilingKey);
                } else {
                    map.put(lowerKey, val);
                }
            }
        } else {
            if (ceilingKey != null && ceilingKey == val + 1) {
                map.put(val, map.get(ceilingKey));
                map.remove(ceilingKey);
            } else {
                map.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index++] = new int[]{(int) entry.getKey(), (int) entry.getValue()};
        }
        return res;
    }
}


public class Solution352 {



}
