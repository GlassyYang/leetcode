import java.util.*;

class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> sta = new LinkedList<>();
        TreeNode cur = root, newRoot = new TreeNode(-1), pre = newRoot;
        while(cur != null) {
            while(cur != null) {
                sta.push(cur);
                cur = cur.left;
            }
            while (cur == null && ! sta.isEmpty()) {
                cur = sta.pop();
                cur.left = null;
                TreeNode temp = cur.right;
                pre.right = cur;
                pre = cur;
                cur = temp;
            }
        }
        return newRoot.right;
    }
}
