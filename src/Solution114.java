import java.util.*;

public class Solution114 {

    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> sta = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.right != null) sta.push(cur.right);
            cur.right = cur.left;
            cur.left = null;
            if(cur.right == null && !sta.isEmpty()) cur.right = sta.pop();
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution114 solu = new Solution114();
        solu.flatten(root);
    }

}
