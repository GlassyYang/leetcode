import java.util.*;
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Stack<Integer> sta = new Stack<>();
        recusive(sta, root, 0, sum, ans);
        return ans;
    }

    public void recusive(Stack<Integer> sta, TreeNode cur, int sum, int target, List<List<Integer>> ans){
        sta.push(cur.val);
        sum += cur.val;
        if(cur.left == null && cur.right == null){
            if(sum == target)ans.add(new ArrayList<>(sta));
            sta.pop();
            return;
        }
        if(cur.left != null) recusive(sta, cur.left, sum, target, ans);
        if(cur.right != null) recusive(sta, cur.right, sum, target, ans);
        sta.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        Solution113 solu = new Solution113();
        System.out.println(solu.pathSum(root, 22));
    }

}
