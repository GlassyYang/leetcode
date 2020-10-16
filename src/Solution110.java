public class Solution110 {

    private static class Tuple{
        boolean isBalanced;
        int high;

        public Tuple(boolean isBalanced, int high) {
            this.isBalanced = isBalanced;
            this.high = high;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return balanced(root).isBalanced;
    }

    private Tuple balanced(TreeNode root){
        if(root.left == null && root.right == null) return new Tuple(true, 1);
        int max = 0;
        int min = 0;
        Tuple left = null;
        if(root.left != null) {
            left = balanced(root.left);
            max = left.high;
        }
        Tuple right = null;
        if(root.right != null){
            right = balanced(root.right);
            min = Math.min(max, right.high);
            max = Math.max(max, right.high);
        }
        boolean balanced = (left == null) || left.isBalanced;
        balanced &= (right == null) || right.isBalanced;
        balanced &= max - min <= 1;
        return new Tuple(balanced, max + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Solution110 solu = new Solution110();
        System.out.println(solu.isBalanced(root));
    }

}
