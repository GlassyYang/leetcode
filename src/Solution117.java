import java.util.*;

public class Solution117 {

    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root, cur = root, pre = null, nextLevel;
        while(level != null){
            cur = level;
            pre = null;
            nextLevel = null;
            while(cur != null){
                if(cur.left != null){
                    if(pre == null){
                        nextLevel = cur.left;
                        pre = cur.left;
                    } else{
                        pre.next = cur.left;
                        pre = cur.left;
                    }
                }
                if(cur.right != null){
                    if(pre == null){
                        nextLevel = cur.right;
                        pre = cur.right;
                    }
                    else{
                        pre.next = cur.right;
                        pre = cur.right;
                    }
                }
                cur = cur.next;
            }
            level = nextLevel;
        }
        return root;
    }

}
