import java.util.*;

public class Solution174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int[] row = new int[dungeon[0].length];
        int[] price = new int[dungeon[0].length];
        for(int i = 0; i < dungeon[0].length; i++){
            if(i == 0){
                price[i] = dungeon[0][i];
                row[i] = dungeon[0][i];
            }else{
                row[i] = dungeon[0][i] + row[i - 1];
                price[i] = row[i] < price[i - 1] ? row[i] : price[i - 1];
            }
        }
        for(int i = 1; i < dungeon.length; i++){
            row[0] = row[0] + dungeon[i][0];
            for (int j = 1; j < dungeon[i].length; j++) {
                row[i] = Math.max(price[i - 1], price[i]) + dungeon[i][j];
                
            }
        }
        System.out.println(row[row.length - 1]);
        return 10;
    }

    public static void main(String[] args) {
        Solution174 solu = new Solution174();
        int[][] test = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        solu.calculateMinimumHP(test);
    }

}
