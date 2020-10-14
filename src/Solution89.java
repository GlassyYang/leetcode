import java.util.*;

public class Solution89 {

    public List<Integer> grayCode(int n) {
        Stack<Integer> sta = new Stack<>();
        sta.push(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        recusive(set, 0, sta, n);
        return new ArrayList<>(sta);
    }

    public boolean recusive(Set<Integer> set, int cur, Stack<Integer> sta, int n){
        if(sta.size() > 0xffffffff >>> (32 - n)) return true;
        int mask = 1, next = 0;
        for(int i = 0; i < n; i++){
            next = cur ^ (mask << i);
            if(!set.contains(next)){
                set.add(next);
                sta.push(next);
                if(recusive(set, next, sta, n)) return true;
                sta.pop();
                set.remove(next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution89 solu = new Solution89();
        System.out.println(solu.grayCode(10));
    }

}
