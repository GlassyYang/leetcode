public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[] ans = new int[obstacleGrid[0].length];
        boolean flag = true;
        for(int i = 0; i < obstacleGrid[0].length; i++){
            flag = (flag == true && obstacleGrid[0][i] != 1) ? true : false;
            ans[i] = flag ? 1 : 0;
        }
        // ans[0] = 1;
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[i].length; j++){
                ans[j] =ans[j] + (j > 0 && obstacleGrid[i][j - 1] != 1 ? ans[j - 1] : 0);
                if(obstacleGrid[i][j] == 1) ans[j] = 0;
            }
        }
        return ans[obstacleGrid[0].length - 1];
    }

}
