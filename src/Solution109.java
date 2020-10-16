public class Solution109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        // 确定链表的长度
        TreeNode root = new TreeNode();
        recusive(head, root);
        return root;
    }

    public void recusive(ListNode head, TreeNode cur){
        ListNode slow = head, fast = head, preSlow = head;
        while(fast != null && fast.next != null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            cur.val = head.val;
            return;
        }
        cur.val = slow.val;
        preSlow.next = null;
        if( slow.next == null){     // 条件有问题
            cur.left = new TreeNode();
            recusive(head, cur.left);
        }else{
            cur.left = new TreeNode();
            cur.right = new TreeNode();
            recusive(head, cur.left);
            recusive(slow.next, cur.right);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(9);
        Solution109 solu = new Solution109();
        TreeNode ans = solu.sortedListToBST(head);
        System.out.println("finished");
    }

}
