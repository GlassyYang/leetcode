import java.util.*;

public class OfferSolution32III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> left = new Stack<>(), right = new Stack<>(), swap;
        List<List<Integer>> ans = new LinkedList<>();
        left.push(root);
        int levelCount = 0;
        while (!left.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            while (!left.isEmpty()) {
                TreeNode node = left.pop();
                level.add(node.val);
                if ((levelCount & 0x1) == 0) {
                    if (node.left != null) right.push(node.left);
                    if (node.right != null) right.push(node.right);
                } else {
                    if (node.right != null) right.push(node.right);
                    if (node.left != null) right.push(node.left);
                }
            }
            swap = right;
            right = left;
            left = swap;
            ans.add(level);
            levelCount++;
        }
        return ans;
    }

}
