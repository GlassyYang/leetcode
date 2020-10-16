import java.util.*;

public class Solution111 {

    private static class Tuple{
        TreeNode node;
        int level;

        public Tuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<Tuple> que = new LinkedList<>();
        que.add(new Tuple(root, 1));
        Tuple cur;
        while(!que.isEmpty()){
            cur = que.poll();
            if(cur.node.left == null && cur.node.right == null) return cur.level;
            if(cur.node.left != null) que.add(new Tuple(cur.node.left, cur.level + 1));
            if(cur.node.right != null) que.add(new Tuple(cur.node.right, cur.level + 1));
        }
        return -1;
    }

}
