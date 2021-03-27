import java.util.*;

public class OfferSolution36 {

    static class Pair {
        Node min;
        Node max;
        Pair(Node min, Node max) {
            this.min = min;
            this.max = max;
        }
    }

    // 递归前序遍历
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Pair ans = recusive(root);
        ans.min.left  = ans.max;
        ans.max.right = ans.min;
        return ans.min;
    }

    public Pair recusive(Node cur) {
        Pair left = null, right = null;
        if(cur.left != null) left = recusive(cur.left);
        if(cur.right != null)right = recusive(cur.right);
        if(left != null) {
            left.max.right = cur;
            cur.left = left.max;
            if(right != null) {
                cur.right = right.min;
                right.min.left = cur;
                return new Pair(left.min, right.max);
            } else {
                return new Pair(left.min, cur);
            }
        } else if (right != null) {
            cur.right = right.min;
            right.min.left = cur;
            return new Pair(cur, right.max);
        }
        return new Pair(cur, cur);
    }

}
