import java.util.*;

public class Solution721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> account : accounts){
            for( int i = 1; i < account.size(); i++) {
                if(map.containsKey(account.get(i))) {

                }
            }
        }
        return null;
    }

}
