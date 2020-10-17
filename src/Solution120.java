import java.util.*;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] ans = new int[triangle.size()];
        List<Integer> cur;
        Arrays.fill(ans, 0);
        ans[0] = triangle.get(0).get(0);
        int pre;
        for (int i = 1; i < triangle.size(); i++) {
            cur = triangle.get(i);
            pre = ans[0];
            ans[0] += cur.get(0);
            for(int j = 1; j < cur.size() - 1; j++){
                int temp = ans[j];
                ans[j] = Math.min(pre, ans[j]) + cur.get(j);
                pre = temp;
            }
            ans[cur.size() - 1] = pre + cur.get(cur.size() - 1);
        }
        int min = ans[0];
        for (int i = 1; i < ans.length; i++) if(min > ans[i]) min = ans[i];
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>(4);
        List<Integer> cur = new ArrayList<>(1);
        cur.add(2);
        test.add(cur);
        cur = new ArrayList<>(2);
        cur.add(3);
        cur.add(4);
        test.add(cur);
        cur = new ArrayList<>(3);
        cur.add(6);
        cur.add(5);
        cur.add(7);
        test.add(cur);
        Solution120 solu = new Solution120();
        cur = new ArrayList<>();
        cur.add(4);
        cur.add(1);
        cur.add(8);
        cur.add(3);
        test.add(cur);
        System.out.println(solu.minimumTotal(test));
    }

}
