public class Pair<T, K> {

    T first;
    K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    public static <T, K> Pair<T, K> createPair(T first, K second) {
        Pair<T, K> pair = new Pair<>(first, second);
        return pair;
    }


}
