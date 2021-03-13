import java.util.*;

public class Solution331 {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        int index = 0;
        while (index < nodes.length) {
            if (nodes[index].equals("#")) {
                if (stack.isEmpty()) return false;
                int top = stack.pop();
                top -= 1;
                if (top > 0) stack.push(top);
            } else {
                if (stack.isEmpty()) return false;
                int top = stack.pop();
                top -= 1;
                if (top > 0) stack.push(top);
                stack.push(2);
            }
            index++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution331 solu = new Solution331();
        System.out.println(solu.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
        System.out.println(solu.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solu.isValidSerialization("9,3,#,#,#"));
        System.out.println(solu.isValidSerialization("1,#"));
        System.out.println(solu.isValidSerialization("#"));
    }

}
