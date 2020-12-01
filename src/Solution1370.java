import java.util.*;

public class Solution1370 {

    public String sortString(String s) {
        int[] buf = new int[32];
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
                list.add(c);
            }
        }
        Collections.sort(list);
        StringBuffer sbuf = new StringBuffer();
        while(!map.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                char c = list.get(i);
                if(map.containsKey(c)){
                    sbuf.append(c);
                    int temp = map.get(c);
                    if(temp > 1)map.put(c,temp - 1);
                    else map.remove(c);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                char c = list.get(i);
                if(map.containsKey(c)){
                    sbuf.append(c);
                    int temp = map.get(c);
                    if(temp > 1)map.put(c,temp - 1);
                    else map.remove(c);
                }
            }
        }
        return sbuf.toString();
    }

    public static void main(String[] args) {
        Solution1370 solu = new Solution1370();
        System.out.println(solu.sortString("rat"));
        System.out.println(solu.sortString("leetcode"));
        System.out.println(solu.sortString("spo"));
    }

}
