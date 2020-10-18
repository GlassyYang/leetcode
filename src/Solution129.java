import java.util.*;

public class Solution129 {

    private static class Tuple{
        TreeNode node;
        int integer;

        public Tuple(TreeNode node, int integer) {
            this.node = node;
            this.integer = integer;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Queue<Tuple> que = new LinkedList<>();
        que.add(new Tuple(root, root.val));
        Tuple cur;
        int next;
        int sum = 0;
        while(!que.isEmpty()){
            cur = que.poll();
            if(cur.node.left != null){
                next = cur.integer * 10;
                next += cur.node.left.val;
                que.add(new Tuple(cur.node.left, next));
            }
            if(cur.node.right != null){
                next = cur.integer * 10;
                next += cur.node.right.val;
                que.add(new Tuple(cur.node.right, next));
            }
            if(cur.node.left == null && cur.node.right == null) sum += cur.integer;
        }
        return sum;
    }
}
