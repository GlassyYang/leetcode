import java.lang.reflect.Array;
import java.util.*;

public class Solution49 {
    // 超时版本
    public List<List<String>> groupAnagrams2(String[] strs) {
        char[] chari = null, charj = null;
        List<String>[] set = new List[strs.length];
        for(int i = 0; i < strs.length; i++){
            set[i] = new ArrayList<>();
            set[i].add(strs[i]);
        }
        boolean flag = true;
        for(int i = 0; i < set.length; i++){
            if(set[i] == null) continue;
            for(int j = i + 1; j < set.length; j++){
                if(set[j] == null) continue;
                chari = set[i].get(0).toCharArray();
                charj = set[j].get(0).toCharArray();
                Arrays.sort(chari);
                Arrays.sort(charj);
                if(Arrays.equals(chari, charj)){
                    set[i].addAll(set[j]);
                    set[j] = null;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> strings : set) if (strings != null)ans.add(strings);
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] chars = null;
        String temp = null;
        List<String> list = null;
        for(String str : strs){
            chars = str.toCharArray();
            Arrays.sort(chars);
            temp = new String(chars);
            if(map.containsKey(temp)) map.get(temp).add(str);
            else {
                list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {
        String[] test = {"eat","tea","tan","ate","nat","bat"};
//        Solution49 solu = new Solution49();
//        solu.groupAnagrams(test);
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        for(String i : map.keySet()){
            for(String j :map.keySet()){
                System.out.println(i == j);
            }
        }
    }

}
