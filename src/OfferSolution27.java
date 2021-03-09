public class OfferSolution27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode mirror = new TreeNode();
        recusive(root, mirror);
        return mirror;
    }

    public void recusive(TreeNode node, TreeNode mirror) {
        mirror.val = node.val;
        if (node.left != null) {
            mirror.right = new TreeNode(node.left.val);
            recusive(node.left, mirror.right);
        }
        if (node.right != null) {
            mirror.left = new TreeNode(node.right.val);
            recusive(node.right, mirror.left);
        }
    }
}
