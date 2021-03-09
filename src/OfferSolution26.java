import java.util.*;

public class OfferSolution26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        // 递归搜索加比较
        if (A.val == B.val && compare(A, B)) return true;
        boolean res = false;
        if (A.left != null) res = isSubStructure(A.left, B);
        if (!res && A.right != null) res = isSubStructure(A.right, B);
        return res;
    }

    public boolean compare(TreeNode a, TreeNode b) {
        if (a.val != b.val) return false;
        boolean res = true;
        if (b.left != null) {
            if(a.left != null) res &= compare(a.left, b.left);
            else return false;
        }
        if (b.right != null) {
            if (a.right != null) res &= compare(a.right, b.right);
            else return false;
        }
        return res;
    }



}
