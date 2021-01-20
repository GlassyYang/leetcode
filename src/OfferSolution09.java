import java.util.*;

public class OfferSolution09 {
}
class CQueue {

    Stack<Integer> head, tail;

    public CQueue() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    public void appendTail(int value) {
        tail.push(value);
    }

    public int deleteHead() {
        while(tail.size() != 0) {
            head.push(tail.pop());
        }
        return head.size() == 0 ? -1 : head.pop();
    }
}
