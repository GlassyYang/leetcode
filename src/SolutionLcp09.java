import java.util.*;
public class SolutionLcp09 {

    static class Pair {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    // 第一种思想：搜索加剪枝
    public int minJump(int[] jump) {
        Queue<Pair> que = new LinkedList<>();
        boolean[] visited = new boolean[jump.length];
        Arrays.fill(visited, false);
        visited[0] = true;
        que.offer(new Pair(0,0));
        int far = 1;
        while(!que.isEmpty()) {
            Pair cur = que.poll();
            int rightNext = jump[cur.index] + cur.index;
            if (rightNext >= jump.length) {
                return cur.count + 1;
            }
            if (!visited[rightNext]) {
                que.offer(new Pair(rightNext, cur.count + 1));
                visited[rightNext] = true;
            }
            for (int i = far; i < cur.index; i++) {
                if (!visited[i]) {
                    que.offer(new Pair(i, cur.count + 1));
                    visited[i] = true;
                }
            }
            far = Math.max(far, cur.index + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionLcp09 solu = new SolutionLcp09();
        int[] test = {4,6,10,8,3,5,3,5,7,8,6,10,3,7,3,10,7,10,10,9,1,4,7,4,8,6,9,8,8,2,7,2,4,5,4,3,3,2,2,2,3,4,4,1,1,5,6,8,1,2};
        System.out.println(solu.minJump(test));
    }

}
