import java.util.*;

public class Solution39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> sta = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        search(candidates, target, ans, 0, sta);
        return ans;
    }

    public static void search(int[] candidates, int target, List<List<Integer>> ans, int cur, Stack<Integer> sta){
        for(int i = 0; i < candidates.length; i++){
            if(cur + candidates[i] < target){
                sta.push(candidates[i]);
                search(candidates, target, ans, cur + candidates[i], sta);
                sta.pop();
            }else if(cur + candidates[i] == target){
                List<Integer> list = new ArrayList<>();
                for(int e : sta){
                    list.add(e);
                }
                list.add(candidates[i]);
                Collections.sort(list);
                for(List<Integer> li : ans){
                    if(li.equals(list)) return;
                }
                ans.add(list);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(2);
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>(2);
        l2.add(2);
        l2.add(1);
        System.out.println(l1.equals(l2));

//        combinationSum(new int[]{4,2,7,5,6}, 16);
    }

}
