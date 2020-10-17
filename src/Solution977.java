import java.util.*;

public class Solution977 {

    public int[] sortedSquares(int[] A) {
        if(A == null) return null;
        int[] B = new int[A.length];
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int e : A){
            que.add(e * e);
        }
        for(int i = 0; i < B.length; i++){
            B[i] = que.poll();
        }
        return B;
    }

}
