public class Solution98 {

    private static class Tuple{
        int max;
        boolean validate;
        int min;

        Tuple(int max, boolean validate, int min){this.max = max; this.validate = validate; this.min = min;}
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Tuple ans = recusive(root);
        return ans.validate;
    }

    public Tuple recusive(TreeNode cur){
        if(cur.left == null && cur.right == null) return new Tuple(cur.val, true, cur.val);
        Tuple tupleLeft = null, tupleRight = null;
        if(cur.left != null) tupleLeft = recusive(cur.left);
        if(cur.right != null) tupleRight = recusive(cur.right);
        boolean validate = tupleLeft == null || tupleLeft.validate && tupleLeft.max < cur.val;
        if(validate && tupleRight != null) validate = tupleRight.validate && tupleRight.min > cur.val;
        return new Tuple(tupleRight != null ? tupleRight.max : cur.val, validate, tupleLeft != null ? tupleLeft.min : cur.val);
    }




}
