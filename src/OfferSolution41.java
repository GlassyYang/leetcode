import java.util.*;

public class OfferSolution41 {

    // 这个题我觉得可以用优先队列,记住中位数后面的所有数字
    class MedianFinder {

        PriorityQueue<Integer> left, right;
        int length;
        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>((a,b)->b-a);
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            length++;
            if (length == 1) {
                left.offer(num);
                return;
            }
            if (num > left.peek()) {
                right.offer(num);
                if (right.size() > left.size()) left.offer(right.poll());
            } else {
                left.offer(num);
                if (left.size() > right.size() + 1) right.offer(left.poll());
            }
        }

        public double findMedian() {
            if ((length & 0x1) == 1) {
                return left.peek();
            } else {
                return ((double)left.peek() + right.peek()) / 2;
            }
        }
    }

    static class StaticClass {

    }

    public static void main(String[] args) {
        OfferSolution41 solu = new OfferSolution41();
        OfferSolution41.MedianFinder finder = solu.new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
