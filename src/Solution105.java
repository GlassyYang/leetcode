import java.util.*;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> sta = new Stack<>();
        sta.push(root);
        int inIndex = 0;
        TreeNode cur;
        for (int i = 1; i < preorder.length; i++) {
            cur = sta.peek();
            if (cur.val != inorder[inIndex]) {
                cur.left = new TreeNode(preorder[i]);
                sta.push(cur.left);
            } else {
                while (!sta.isEmpty() && sta.peek().val == inorder[inIndex]) {
                    cur = sta.pop();
                    inIndex++;
                }
                cur.right = new TreeNode(preorder[i]);
                sta.push(cur.right);
            }
        }
        return root;
    }
}
