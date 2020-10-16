public class Solution116 {

    // 用常量空间复杂度做这个题
    public Node connect(Node root) {
        Node level = root, cur = root, pre = root;
        while(level != null){
            if(level.left != null) level.left.next = level.right;
            else break;
            cur = level.next;
            pre = level.right;
            if(pre == null) continue;
            while(cur != null){
                pre.next = cur.left;
                cur.left.next = cur.right;
                pre = cur.right;
                if(pre == null) break;
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }



}
