import java.util.*;

public class LcpSolution19 {

    public int minimumOperations(String leaves) {
        final int n = leaves.length();
        int state0 = leaves.charAt(0) == 'y' ? 1 : 0,  state1 = 1000000000, state2 = 1000000000;
        for (int i = 1; i < n; i++) {
            char c = leaves.charAt(i);
            state2 = Math.min(state1, state2) + (c == 'y' ? 1 : 0);
            state1 = Math.min(state1, state0) + (c == 'r' ? 1 : 0);
            state0 = state0 + (c == 'y' ? 1 : 0);
        }
        return state2;
    }

    public static void main(String[] args) {
        LcpSolution19 solu = new LcpSolution19();
        System.out.println(solu.minimumOperations("rrryyyrryyyrr"));
    }

}
