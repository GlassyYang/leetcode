import java.util.*;

public class Solution388 {

    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t就是第一层）
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution388 solu = new Solution388();
        System.out.println(solu.lengthLongestPath("dir\n        file.txt"));
    }

}
