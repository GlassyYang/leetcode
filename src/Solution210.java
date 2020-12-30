import java.util.*;
public class Solution210 {

    // 拓扑排序的方法解决这个问题
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> backAdjcent[] = new Set[numCourses];
        for(int[] pair : prerequisites) {
            if(backAdjcent[pair[1]] == null) backAdjcent[pair[1]] = new HashSet<>();
            backAdjcent[pair[1]].add(pair[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(backAdjcent[i] == null) {
                que.offer(i);
                break;
            }
        }
        if(que.size() == 0) return new int[0];
        while(!que.isEmpty()) {
            int index = que.poll();
            ans.add(index);
            if (backAdjcent[index] != null)
                for ( int e : backAdjcent[index]) que.offer(e);
        }
        if (ans.size() != numCourses) return new int[0];
        int[] ansArr = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        int nums = 2;
        int[][] adjcent = {{1,0}};
        Solution210 solu = new Solution210();
        System.out.println(Arrays.toString(solu.findOrder(nums, adjcent)));
    }

}
