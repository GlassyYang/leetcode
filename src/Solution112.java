import java.util.*;

public class Solution112 {

    private static class Tuple{
        TreeNode node;
        int sum;
        public Tuple(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root ==  null) return false;
        Queue<Tuple> que = new LinkedList<>();
        que.add(new Tuple(root, root.val));
        Tuple cur;
        while(!que.isEmpty()){
            cur = que.poll();
            if(cur.node.left == null && cur.node.right == null){
                if(cur.sum == sum) return true;
            }else{
                if(cur.node.left != null) que.add(new Tuple(cur.node.left, cur.sum + cur.node.left.val));
                if(cur.node.right != null) que.add(new Tuple(cur.node.right, cur.sum + cur.node.right.val));
            }
        }
        return false;
    }

}
