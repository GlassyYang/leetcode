public class Solution64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[] ans = new int[grid[0].length];
        ans[0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++){
            ans[i] = ans[i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                ans[j] = ((j == 0) ? ans[j] : Math.min(ans[j], ans[j - 1])) + grid[i][j];
            }
        }
        return ans[grid[0].length - 1];
    }

}
