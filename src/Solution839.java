import java.util.*;

public class Solution839 {

    class UnionFind{
        int[] parents;
        int count;
        public UnionFind(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (parents[i] != i) {
                parents[i] =  parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        boolean merge(int i, int j) {
            int parentX = find(i), parentY = find(j);
            if (parentX == parentY) return false;
            parents[parentX] = parentY;
            count--;
            return true;
        }

    }

    boolean check(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) uf.merge(i, j);
            }
        }
        return uf.count;
    }

}
