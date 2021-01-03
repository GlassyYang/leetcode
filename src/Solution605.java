import java.util.*;

public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) continue;
            flag = true;
            if(i > 0 && flowerbed[i - 1] == 1) flag = false;
            if(i < flowerbed.length - 1 && flowerbed[i + 1] == 1) flag = false;
            if(flag) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] test = {1,0,0,0,1};
        Solution605 solu = new Solution605();
        System.out.println(solu.canPlaceFlowers(test, 2));
    }

}
