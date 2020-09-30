import java.util.*;
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> sta = new Stack<>();
        sta.push(cur);
        while(!sta.isEmpty()){
            if(cur == null){
                cur = sta.pop();
            }
            while(cur != null){
                sta.push(cur.right);
                sta.push(cur.left);
                cur = cur.left;
            }
        }
        return null;
    }


}
