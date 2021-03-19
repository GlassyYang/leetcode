import java.math.BigInteger;
import java.util.*;

public class Solution1606 {
    Map<Integer, Integer> map = new HashMap<>();
    // method 1: 暴力模拟法，超出时间限制
    public List<Integer> busiestServersForce(int k, int[] arrival, int[] load) {
        BigInteger a = new BigInteger("123456788888888");
        BigInteger b = a.abs();
        Map<Integer, Integer> map = new Hashtable<>();
        int[] jobs = new int[k], finished = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            int server = i % k;
            if (jobs[server] <= arrival[i]) {
                jobs[server] = arrival[i] + load[i];
                finished[server]++;
            } else {
                // 说明默认插入的服务器是忙的，因此循环找到新的服务器
                int temp = server;
                server = (server + 1) % k;
                while (jobs[server] > arrival[i] && temp != server) {
                    server++;
                    server %= k;
                }
                if (temp != server) {
                    jobs[server] = arrival[i] + load[i];
                    finished[server]++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int max = -1;
        for (int i : finished) {
            if (max < i) max = i;
        }
        for (int i = 0; i < k; i++) {
            if (max == finished[i]) ans.add(i);
        }
        return ans;
    }

    private static class Pair {
        int server;
        int ftime;

        public Pair(int server, int ftime) {
            this.server = server;
            this.ftime = ftime;
        }
    }

    // 方法二：还是模拟，但是在暴力模拟的基础上做一些优化
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] finished = new int[k];
        PriorityQueue<Pair> busy = new PriorityQueue<>((a,b) -> a.ftime - b.ftime);
        TreeSet<Pair> free = new TreeSet<>((a,b) -> a.server - b.server);
        for (int i = 0; i < k; i++) {
            free.add(new Pair(i, 0));
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek().ftime <= arrival[i]) free.add(busy.poll());
            if (free.isEmpty()) continue;
            Pair server = new Pair(i % k, 0);
            if (free.contains(server)) {
                free.remove(server);
                server.ftime = arrival[i] + load[i];
                finished[server.server]++;
                busy.offer(server);
            } else {
                Pair next = free.ceiling(server);
                if (next == null) {
                    server.server = -1;
                    next = free.ceiling(server);
                }
                free.remove(next);
                next.ftime = arrival[i] + load[i];
                finished[next.server]++;
                busy.offer(next);
            }
        }
        List<Integer> ans = new LinkedList<>();
        int max = -1;;
        for (int i : finished) {
            if (max < i) max = i;
        }
        for (int i = 0; i < k; i++) {
            if (max == finished[i]) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1606 solu = new Solution1606();
        int[] arrival = { 1, 2, 3, 4, 5 };
        int[] load = { 5, 2, 3, 3, 3 };
        System.out.println(solu.busiestServers(3, arrival, load));
    }

}
