import java.util.*;

class UnionFind {
    private final int[] parents;
    private int count;

    public UnionFind(int numberOfStones) {
        count = numberOfStones;
        parents = new int[count];
        for(int i = 0; i < count; ++i) {
            parents[i] = i;
        }
    }

    public int findParent(int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int parentI = findParent(i), parentJ = findParent(j);
        if(parentI == parentJ) {
            return;
        }
        parents[parentI] = parentJ;
        count--;
    }

    public int getCount() {
        return count;
    }
}

public class Solution947 {

    public int removeStones(int[][] stones) {
        final int length = stones.length;
        UnionFind unionFind = new UnionFind(length);
        Map<Integer, Integer> rowMap = new HashMap<>(), columnMap = new HashMap<>();
        for(int i = 0; i < length; ++i) {
            int[] stone = stones[i];
            if (rowMap.containsKey(stone[0])) {
                unionFind.union(i, rowMap.get(stone[0]));
            } else {
                rowMap.put(stone[0], i);
            }
            if(columnMap.containsKey(stone[1])) {
                unionFind.union(i, columnMap.get(stone[1]));
            } else {
                columnMap.put(stone[1], i);
            }
        }
        return stones.length - unionFind.getCount();
    }

    public static void main(String[] args) {
        int[][] stones = {{3,2},{0,0},{3,3},{2,1},{2,3},{2,2},{0,2}};
        Solution947 solution947 = new Solution947();
        System.out.println(solution947.removeStones(stones));
    }
}
