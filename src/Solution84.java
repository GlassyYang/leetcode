import java.util.*;
// 数据结构经典例题，两种解法
public class Solution84 {
    // 1. 暴力解法
    public int largestRectangleArea1(int[] heights) {
        if(heights == null) return 0;
        int left, right;
        int max = 0, cur;
        for(int i = 0; i < heights.length; i++){
            left = i;
            while(left >= 0 && heights[left] >= heights[i]) left--;
            right = i;
            while(right < heights.length && heights[right] >= heights[i]) right++;
            cur = (right - left - 1) *  heights[i];
            if(cur > max) max = cur;
        }
        return max;
    }
    //2. 单调栈解决该问题
    public int largestRectangleArea(int[] heights){
        if(heights == null) return 0;
        Stack<Integer> sta = new Stack<>();
        int max = 0;
        int cur, temp;
        for(int i = 0; i < heights.length; i++){
            if(sta.isEmpty() || heights[sta.peek()] <= heights[i]) sta.push(i);
            else{
                while(!sta.isEmpty() && heights[sta.peek()] > heights[i]){
                    temp = sta.pop();
                    if(sta.isEmpty()) cur = heights[temp] * i;
                    else cur = heights[temp] * (i -sta.peek() - 1);
                    if(cur > max) max = cur;
                }
                sta.push(i);
            }
        }
        while (!sta.isEmpty()){
            temp = sta.pop();
            if(sta.isEmpty()) cur = heights[temp] * heights.length;
            else cur = heights[temp] * (heights.length - sta.peek() - 1);
            if(cur > max) max = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution84 solu = new Solution84();
        int[] test = {2,1,5,6,2,3};
        System.out.println(solu.largestRectangleArea(test));
    }

}
