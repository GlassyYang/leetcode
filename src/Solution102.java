import java.util.*;

public class Solution102 {

    private static class Tuple{
        TreeNode node;
        int level;
        public Tuple(TreeNode node, int level){this.node = node; this.level = level;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
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
        return ans;
    }

    public static void main(String[] args) {
        Solution102 solu = new Solution102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solu.levelOrder(root));
    }

}
