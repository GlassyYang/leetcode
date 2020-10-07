public class Solution96 {
    // 使用卡塔兰数解决这个问题
    public int numTrees(int n) {
        double ans = 1;
        for(int i = 0; i < n; i++){
            ans = (4 * i + 2) / (i + 2.0) * ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {

    }

}
