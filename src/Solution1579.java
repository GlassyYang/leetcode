import java.util.*;

public class Solution1579 {

    class UnionFind {
        int[] parents;
        int count;

        UnionFind(int n) {
            this.count = n;
            this.parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        UnionFind (UnionFind copy) {
            this.count = copy.count;
            this.parents = new int[copy.parents.length];
            for (int i = 0; i < this.parents.length; i++) {
                this.parents[i] = copy.parents[i];
            }
        }

        int find(int i) {
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        boolean merge(int i, int j) {
            int ancestorI = find(i - 1), ancestorJ = find(j - 1);
            if (ancestorI == ancestorJ) return false;
            parents[ancestorI] = ancestorJ;
            count--;
            return true;
        }

        int getCount() {
            return this.count;
        }

    }

    // 初步想法：搜索或者并查集，先添加连你跟着的公共边，之后再分别给Alice和Bob添加边
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        //排序的时间复杂度有点高，过不了
//        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        UnionFind common = new UnionFind(n), alice = null, bob = null;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (common.count > 1) {
                    if (!common.merge(edge[1], edge[2])) ans++;
                } else ans++;
            }
        }
        alice = new UnionFind(common);
        bob = new UnionFind(common);
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.count > 1) {
                    if (!alice.merge(edge[1], edge[2])) ans++;
                } else {
                    ans++;
                }
            } else if (edge[0] == 2) {
                if (bob.count > 1) {
                    if (!bob.merge(edge[1], edge[2])) ans++;
                } else {
                    ans++;
                }
            }
        }

        if (common.count > 1 && (alice.count > 1 || bob.count > 1)) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1579 solu = new Solution1579();
        int[][] test = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
//        int[][] test = {{1,1,2},{2,1,2}};
        System.out.println(solu.maxNumEdgesToRemove(4, test));
    }

}
