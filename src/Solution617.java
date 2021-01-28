import java.util.*;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode root = new TreeNode();
        recusive(t1, t2, root);
        return root;
    }

    public void recusive(TreeNode t1, TreeNode t2, TreeNode merge) {
        if (t1 == null) {
            merge.val = t2.val;
            merge.left = t2.left;
            merge.right = t2.right;
        }
        else if (t2 == null) {
            merge.val = t1.val;
            merge.left = t1.left;
            merge.right = t1.right;
        }
        else {
            merge.val = t1.val + t2.val;
            if (t1.left != null || t2.left != null) {
                merge.left = new TreeNode();
                recusive(t1.left, t2.left, merge.left);
            }
            if (t1.right != null || t2.right != null) {
                merge.right = new TreeNode();
                recusive(t1.right, t2.right, merge.right);
            }
        }
    }
}
