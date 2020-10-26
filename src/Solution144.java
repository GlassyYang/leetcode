import java.util.*;

public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new LinkedList<>();
        if(root == null) return ans;
        Stack<TreeNode> que = new Stack<>();
        TreeNode cur = root;
        while (cur != null){
            ans.add(cur.val);
            if(cur.right != null) que.push(cur.right);
            cur = cur.left;
            if(cur == null && !que.isEmpty()) cur = que.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
