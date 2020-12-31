import java.util.*;

public class Solution1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> sta = new Stack<>();
        sta.push(root);
        TreeNode cur;
        for (int i = 1; i < preorder.length; i++) {
            cur = sta.peek();
            if (preorder[i] < cur.val) {
                cur.left = new TreeNode(preorder[i]);
                sta.push(cur.left);
            } else {
                sta.pop();
                while(!sta.isEmpty() && sta.peek().val < preorder[i]) cur = sta.pop();
                cur.right = new TreeNode(preorder[i]);
                sta.push(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        Solution1008 solu = new Solution1008();
        solu.bstFromPreorder(preorder);
    }

}
