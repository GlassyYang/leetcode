import java.util.*;

public class Solution232 {

    // 用栈实现队列，就是在两个栈里面互相捯饬
    class MyQueue {

        Stack<Integer> push;
        Stack<Integer> pop;
        int length;
        /** Initialize your data structure here. */
        public MyQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!pop.isEmpty()) push.push(pop.pop());
            push.push(x);
            length++;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!push.isEmpty()) pop.push(push.pop());
            length--;
            return pop.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!push.isEmpty()) pop.push(push.pop());
            return pop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return length == 0;
        }
    }

}
