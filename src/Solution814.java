public class Solution814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        // 递归方法剪枝
        if (treeContainOne(root)) return root;
        return null;
    }

    public boolean treeContainOne(TreeNode node) {
        boolean contain = false, temp;
        if (node.left != null) {
            temp = treeContainOne(node.left);
            if (!temp) node.left = null;
            contain &= temp;
        }
        if (node.right != null)  {
            temp = treeContainOne(node.right);
            if (!temp) node.right = null;
        }
        if (node.val == 1) contain = true;
        return contain;
    }

    //  第二种方法：后序遍历

}
