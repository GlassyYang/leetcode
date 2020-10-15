import java.util.*;

public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        // 反转数组inorder
        for(int i = 0; i < inorder.length / 2; i++){
            inorder[i] = inorder[inorder.length - 1 - i] + inorder[i];
            inorder[inorder.length - 1 - i] = inorder[i] - inorder[inorder.length - 1 -i];
            inorder[i] = inorder[i] - inorder[inorder.length - 1 -i];
        }
        Stack<TreeNode> sta = new Stack<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        sta.push(root);
        int inIndex = 0;
        TreeNode cur;
        for(int i = postorder.length - 2; i >= 0; i--){
            cur = sta.peek();
            if(cur.val != inorder[inIndex]){
                cur.right = new TreeNode(postorder[i]);
                sta.push(cur.right);
            }else{
                while(!sta.isEmpty() && sta.peek().val == inorder[inIndex]){
                    inIndex++;
                    cur = sta.pop();
                }
                cur.left = new TreeNode(postorder[i]);
                sta.push(cur.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7}, post = {9,15,7,20,3};
        Solution106 solu = new Solution106();
        TreeNode ans = solu.buildTree(in, post);
    }

}
