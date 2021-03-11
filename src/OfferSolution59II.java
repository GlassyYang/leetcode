import java.util.*;

public class OfferSolution59II {



}

class MaxQueue {

    Queue<Integer> que;
    Deque<Integer> max;

    public MaxQueue() {
        que = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        que.offer(value);
        while (!max.isEmpty() && max.peekLast() < value ) max.pollLast();
        max.offerLast(value);
    }

    public int pop_front() {
        if (que.isEmpty()) return -1;
        int value = que.poll();
        if (value == max_value()) max.pollFirst();
        return value;
    }
}
