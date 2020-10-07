import java.util.*;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = null;
        if(root == null) return ans;
        Stack<TreeNode> sta = new Stack<>();
        sta.push(root);
        while(!sta.isEmpty()){
            cur = sta.pop();
            while(cur != null) {
                sta.push(cur);
                cur = cur.left;
            }
            cur = sta.pop();
            ans.add(cur.val);
            sta.push(cur.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution94 solu = new Solution94();

    }

}
