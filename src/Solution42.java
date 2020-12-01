import java.util.*;

public class Solution42 {
    // 单调栈解决
    public int trap(int[] height) {
        Stack<Integer> sta = new Stack<>();
        int pre = 0, ans = 0;
        for (int i = 0; i < height.length; i++) {
            if(sta.isEmpty() || height[i] < height[sta.peek()]){
                sta.push(i);
            }
            else{
                while(!sta.isEmpty() && height[sta.peek()] <= height[i]){
                    ans += (height[sta.peek()] - pre) * (i - sta.peek() - 1);
                    pre = height[sta.pop()];
                }
                if(!sta.isEmpty()) ans += (height[i] - pre) * (i - sta.peek() - 1);
                pre = 0;
                sta.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = {4,2,0,3,2,5};
        Solution42 solu = new Solution42();
        System.out.println(solu.trap(height));
    }

}
