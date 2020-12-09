import java.util.*;

public class Solution200 {

    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        Stack<Integer> row = new Stack<>();
        Stack<Integer> column = new Stack<>();
        int curI, curJ, count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    row.push(i);
                    column.push(j);
                    grid[i][j] = '2';
                    while(!row.isEmpty()){
                        curI = row.pop();
                        curJ = column.pop();
                        if(curI + 1 < grid.length && grid[curI + 1][curJ] == '1'){
                            row.push(curI + 1);
                            column.push(curJ);
                            grid[curI + 1][curJ] = '2';
                        }
                        if(curI - 1 >= 0 && grid[curI - 1][curJ] == '1'){
                            row.push(curI - 1);
                            column.push(curJ);
                            grid[curI - 1][curJ] = '2';
                        }
                        if(curJ + 1 < grid[i].length && grid[curI][curJ + 1] == '1'){
                            row.push(curI);
                            column.push(curJ +  1);
                            grid[curI][curJ + 1] = '2';
                        }
                        if(curJ - 1 >= 0 && grid[curI][curJ - 1] == '1'){
                            row.push(curI);
                            column.push(curJ -  1);
                            grid[curI][curJ - 1] = '2';
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution200 solu = new Solution200();
        char[][] grid = {{'1','0','1','1','1'},
                          {'1','0','1','0','1'},
                          {'1','1','1','0','1'}};
//        char[][] grid = {{'0'}};
        System.out.println(solu.numIslands(grid));
    }

}
