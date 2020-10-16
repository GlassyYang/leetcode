import java.util.*;
public class Solution107 {
    private static class Tuple{
        TreeNode node;
        int level;
        public Tuple(TreeNode node, int level){this.node = node; this.level = level;}
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> ans = new Stack<>();
        Queue<Tuple> que = new LinkedList<>();
        if(root != null) que.add(new Tuple(root, 0));
        List<Integer> cur = new ArrayList<>();
        Tuple tup;
        int level = 0;
        while(!que.isEmpty()){
            tup = que.poll();
            if(tup.node.left != null) que.add(new Tuple(tup.node.left, tup.level + 1));
            if(tup.node.right != null) que.add(new Tuple(tup.node.right, tup.level + 1));
            if(tup.level != level){
                level = tup.level;
                ans.add(cur);
                cur = new ArrayList<>();
            }
            cur.add(tup.node.val);
        }
        if(cur.size() != 0) ans.add(cur);
        Collections.reverse(ans);
        return ans;
    }
}
