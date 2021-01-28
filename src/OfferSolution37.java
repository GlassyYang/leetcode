import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class OfferSolution37 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(codec.serialize(root));
    }

}

/*
 * 序列化和反序列化二叉树，可以看到序列化二叉树用的是层析搜索，反序列化二叉树也是层次搜索
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode temp;
        que.offer(root);
        while (!que.isEmpty()) {
            temp = que.poll();
            if (temp == null) ans.add(null);
            else {
                ans.add(temp.val);
                que.offer(temp.left);
                que.offer(temp.right);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < ans.size() - 1; i++) {
            builder.append(ans.get(i));
            builder.append(',');
        }
        builder.append(ans.get(ans.size() - 1));
        builder.append(']');
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = null, temp;
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) return root;
        String[] slice = data.split(",");
        int index = 0;
        if (slice.length > 0 && !slice[0].equals("null")) {
            root = new TreeNode();
            root.val = Integer.parseInt(slice[0]);
            que.offer(root);
            index++;
            while (index < slice.length) {
                temp = que.poll();
                if (!slice[index].equals("null")) {
                    temp.left = new TreeNode(Integer.parseInt(slice[index]));
                    que.offer(temp.left);
                }
                index++;
                if (index < slice.length && !slice[index].equals("null")) {
                    temp.right = new TreeNode(Integer.parseInt(slice[index]));
                    que.offer(temp.right);
                }
                index++;
            }
        }
        return root;
    }
}
