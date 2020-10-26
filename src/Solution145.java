import java.util.*;
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> sta = new Stack<>();
        while(cur != null || !sta.isEmpty()){
            while(cur != null) {
                sta.push(cur);
                cur = cur.left;
            }
            cur = sta.pop();
            if(cur.right == null || cur.right == prev){
                ans.add(cur.val);
                prev = cur;
                cur = null;
            }else{
                sta.push(cur);
                cur = cur.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
