import java.util.*;

public class Solution1409 {
    // TODO
    public int[] processQueries(int[] queries, int m) {
        TreeMap<Integer, Integer> numberLocation = new TreeMap<>();
        TreeSet<Integer> posVal = new TreeSet<>();
        int[] result = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++) {
            if(!numberLocation.containsKey(queries[i])) {
                result[i] = numberLocation.tailMap(queries[i] + 1).size() + queries[i] - 1;
            }
            else {
                result[i] = posVal.tailSet(numberLocation.get(queries[i]) + 1).size();
                posVal.remove(numberLocation.get(queries[i]));
            }
            numberLocation.put(queries[i], i);
            posVal.add(i);
        }
        return result;
    }

}


