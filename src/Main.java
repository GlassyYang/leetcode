import java.util.Stack;

class SolutionI {
    public boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); ++i) {
            char chr = str.charAt(i);
            switch (chr) {
                case '{':
                case '[':
                case '(':
                    stack.push(chr);
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }
}

class SolutionII {
    private int sum = 0;

    public void treeSumDfs(TreeNode node, int cur) {
        cur *= 10;
        cur += node.val;
        if(node.left == null && node.right == null) {
            sum += cur;
        }
        if(node.left != null) {
            treeSumDfs(node.left, cur);
        }
        if (node.right != null){
            treeSumDfs(node.right, cur);
        }
    }

    public int treeSum(TreeNode root) {
        sum = 0;
        if(root == null) {
            return sum;
        }
        treeSumDfs(root, 0);
        return sum;
    }
}

public class Main {

    public static void main(String[] args) {
        SolutionI solutionI = new SolutionI();
        System.out.println(solutionI.solution("()(  [ ]{} )"));
        System.out.println(solutionI.solution("(])"));

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        SolutionII solutionII = new SolutionII();
        System.out.println(solutionII.treeSum(root));
    }
}
