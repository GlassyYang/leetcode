import java.util.*;

public class SolutionLCP23 {

    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = i + 1;
        // 模拟
        return shuffleCards(cards, target, 0, -1);
    }

    private boolean shuffleCards(int[] cards, int[] target, int idx, int k) {
        if (idx >= cards.length) return true;
        int[] tmp = Arrays.copyOf(cards, cards.length);
        int insert = idx;
        for (int j = idx + 1; j < cards.length; j += 2) cards[insert++] = tmp[j];
        for (int j = idx; j < cards.length; j += 2) cards[insert++] = tmp[j];
        int curK = 0;
        for (int i = idx; i < cards.length; i++) {
            if (target[i] != cards[i]) break;
            curK++;
        }
        if (k == -1) k = curK;
        if (curK == 0 || idx + curK < cards.length && curK < k) return false;

        return shuffleCards(cards, target, idx + k, k);
    }

}
