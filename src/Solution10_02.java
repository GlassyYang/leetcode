import java.util.*;

public class Solution10_02 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sarr = strs[i].toCharArray();
            Arrays.sort(sarr);
            String res = new String(sarr);
            if (map.containsKey(res)) {
                int index = map.get(res);
                ans.get(index).add(strs[i]);
            } else {
                map.put(res, ans.size());
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                ans.add(list);
            }
        }
        return ans;
    }

}
