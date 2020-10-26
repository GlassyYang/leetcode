import java.util.*;

public class Solution845 {

    public int longestMountain(int[] A) {
        if(A == null || A.length < 3) return 0;
        int count = 0;
        int max = 0;
        boolean up = true;
        for(int i = 0; i < A.length - 1; i++){
            if(up && A[i] < A[i + 1]){
                if(count == 0){
                    int temp = i;
                    while(temp > 0 && A[temp - 1] < A[temp]){
                        count++;
                        temp--;
                    }
                }
                count++;
            }
            else if(up && A[i] > A[i + 1]){
                if(count == 0){
                    int temp = i;
                    while(temp > 0 && A[temp - 1] < A[temp]){
                        count++;
                        temp--;
                    }
                }
                if(count == 0){
                    up = true;
                    continue;
                }
                up = false;
                count++;
            }else if(!up && A[i] > A[i + 1]) count++;
            else if(!up && A[i] <= A[i + 1]){
                count++;
                if(count > max) max = count;
                count = 0;
                up = true;
            }else{
                count = 0;
                up = true;
            }
        }
        if(!up && A[A.length - 2] > A[A.length - 1]) count++;
        if(up) return max;
        return Math.max(max, count);
    }

    public static void main(String[] args) {
//        int[] A = {2,1,4,7,3,2,5, 6,7,8,9,8,7,6};
//        int[] A = {2,2,2};
//        int[] A = {0,1,2,3,4,5,4,3,2,1,0};
        int[] A = {0,0,1,0,0,1,1,1,1,1};
//        int[] A = {875,884,239,731,723,685};
        Solution845 solu = new Solution845();
        System.out.println(solu.longestMountain(A));
    }

}
