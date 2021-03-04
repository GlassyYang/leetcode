import java.util.*;

public class OfferSolution30 {

    class MinStack {

        private Stack<Integer> sta;
        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            sta = new Stack<>();
        }

        public void push(int x) {
            if (sta.isEmpty()) min =x;
            else min = Math.min(x, min);
            sta.push(x);
        }

        public void pop() {
            int x = sta.pop();
            if (sta.isEmpty()) return;
            if (x == min) {
                min = sta.peek();
                Iterator<Integer> i = sta.iterator();
                while (i.hasNext()) {
                    int temp = i.next();
                    if (temp < min) min = temp;
                }
            }
        }

        public int top() {
            return sta.peek();
        }

        public int min() {
            return min;
        }
    }

}
