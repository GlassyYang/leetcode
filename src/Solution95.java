import java.util.*;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        return ans;
    }

    public void recusive(List<TreeNode> ans, TreeNode cur, TreeNode root, Set<Integer> notChoose, Set<Integer> choosed){
        if(notChoose.size() == 0){
            //执行树copy函数，
            return;
        }else if(notChoose.size() == 1){
            for(int e : notChoose){
                cur.left = new TreeNode(e);
                // 执行树copy函数
                cur.right = cur.left;
                cur.left = null;
                //在执行一遍copy函数
            }
        }else{


        }
    }


}
