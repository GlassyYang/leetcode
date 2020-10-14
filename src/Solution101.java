public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if((root.left == null || root.right == null) && root.left != root.right) return false;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left.val != right.val) return false;
        if((left.left == null || right.right == null) && left.left != right.right) return false;
        if((left.right == null || right.left == null) && left.right != right.left) return false;
        if(left.right != null && left.right.val != right.left.val) return false;
        if(left.left != null && left.left.val != right.right.val) return false;
        boolean flag = true;
        if(left.left != null) flag &= isSymmetric(left.left, right.right);
        if(left.right != null) flag &= isSymmetric(left.right, right.left);
        return flag;
    }

    public static void main(String[] args) {
        Solution101 solu = new Solution101();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(8);
        System.out.println(solu.isSymmetric(root));
    }

}
