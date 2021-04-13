import java.util.*;

public class HuaweiDfs {

    static Stack<Integer> sta = new Stack<>();
    static StringBuilder builder = new StringBuilder();
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] buf = new int[10];
        int n = 0;
        while (input.hasNext()) {
            n = input.nextInt();
            for (int i = 0; i < n; i++) {
                buf[i] = input.nextInt();
            }
            Arrays.sort(buf, 0, n);
            Arrays.fill(visited, 0, n, false);
            dfs(buf, n);
        }
    }


    public static void dfs(int[] buf, final int n) {
        Arrays.fill(visited, 0, n, false);
        sta.clear();
        sta.push(0);
        sta.push(-1);
        while (sta.size() > 1) {
            int next = sta.pop() + 1;
            int cur = sta.peek();
            boolean flag = true;
            for (int i = next; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sta.push(i);
                    sta.push(-1);
                    flag = false;
                }
            }
            if (flag) {
                builder.setLength(0);
                for (Integer integer : sta) {
                    builder.append(integer);
                    builder.append(' ');
                }
                builder.deleteCharAt(builder.length() - 1);
                System.out.println(builder.toString());
            }
        }
    }

}
