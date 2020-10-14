import java.util.*;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Stack<TreeNode>[] stacks = new Stack[2];
        for(int i = 0; i < stacks.length; i++){
            stacks[i] = new Stack<>();
        }
        int index = 0;
        int opposite = 1;
        int level = 1;
        List<Integer> cur = new LinkedList<>();
        stacks[index].push(root);
        TreeNode curNode;
        while(!stacks[index].isEmpty()){
            curNode = stacks[index].pop();
            //重新写
            if((index & 0x1) == 0){
                if(curNode.left != null) stacks[opposite].push(curNode.left);
                if(curNode.right != null) stacks[opposite].push(curNode.right);
            }else{
                if(curNode.right != null) stacks[opposite].push(curNode.right);
                if(curNode.left != null) stacks[opposite].push(curNode.left);
            }
            cur.add(curNode.val);
            if(stacks[index].isEmpty()){
                index = index + opposite;
                opposite = index - opposite;
                index = index - opposite;
                ans.add(cur);
                cur = new LinkedList<>();
                level++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution103 solu = new Solution103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solu.zigzagLevelOrder(root));
    }

}
