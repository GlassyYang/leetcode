public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        if(p.val != q.val) return false;
        if((p.left == null || q.left == null) && p.left != q.left) return false;
        if((p.right == null || q.right == null) && p.right != q.right) return false;
        boolean flag = true;
        if(p.left != null) flag = isSameTree(p.left, q.left);
        if(p.right != null) flag &= isSameTree(p.right, q.right);
        return flag;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        Solution100 solu = new Solution100();
        System.out.println(solu.isSameTree(p, q));
    }

}
