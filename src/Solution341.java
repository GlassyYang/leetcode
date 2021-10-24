import java.util.*;

public class Solution341 {

}
class NestedIterator implements Iterator<Integer> {

    List<Integer> ans;
    int index = 0;
    private void recusive(List<NestedInteger> list) {
        for (int i = 0; i < list.size(); i++) {
            NestedInteger cur = list.get(i);
            if (cur.isInteger()) ans.add(cur.getInteger());
            else recusive(cur.getList());
        }
    }

    private void generateAnswer(List<NestedInteger> list) {
        Stack<List<NestedInteger>> sta = new Stack<>();
        Stack<Integer> index = new Stack<>();
        sta.push(list);
        index.push(0);
        while (!sta.isEmpty()) {
            List<NestedInteger> curList = sta.peek();
            int curIndex = index.pop();
            if (curIndex >= curList.size()) {
                sta.pop();
            } else {
                NestedInteger ni = curList.get(curIndex);
                index.push(curIndex + 1);
                if (ni.isInteger()) {
                    ans.add(ni.getInteger());
                } else {
                    sta.push(curList);
                    sta.push(ni.getList());
                    index.push(curIndex);
                    index.push(0);
                }
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
//        recusive(nestedList);
        generateAnswer(nestedList);
    }

    @Override
    public Integer next() {
        return ans.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < ans.size();
    }
}
