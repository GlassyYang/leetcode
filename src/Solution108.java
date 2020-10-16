public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode();
        recusive(nums, 0, nums.length, root);
        return root;
    }

    public void recusive(int[] nums, int start, int end, TreeNode cur){
        if(start + 1 == end){
            cur.val = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        cur.val = nums[mid];
        if(start == mid) {
            cur.right = new TreeNode();
            recusive(nums, start + 1, end, cur.right);
        }else {
            cur.left = new TreeNode();
            recusive(nums, start, mid, cur.left);
            if(mid + 1 < end){
                cur.right = new TreeNode();
                recusive(nums, mid + 1, end, cur.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Solution108 solu = new Solution108();
        solu.sortedArrayToBST(nums);
    }
}
