public class OfferSolution28 {
    // 感觉不对
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return symmetricEqual(root.left, root.right);
    }

    public boolean symmetricEqual(TreeNode left, TreeNode right) {
        if (left.val  != right.val) return false;
        boolean ans = true;
        if (left.left != null) {
            if (right.right != null) ans &= symmetricEqual(left.left, right.right);
            else return false;
        } else if (right.right != null) return false;
        if (ans && left.right != null) {
            if (right.left != null) ans &= symmetricEqual(left.right, right.left);
            else return false;
        }  else if (ans && right.left != null) return false;
        return ans;
    }

    public static void main(String[] args) {

    }

}
