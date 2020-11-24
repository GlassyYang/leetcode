import java.util.*;

public class Solution222 {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            root = que.poll();
            if(root.left != null){
                que.add(root.left);
                count++;
            }
            if(root.right != null){
                que.add(root.right);
                count++;
            }
        }
        return count;
    }

}
