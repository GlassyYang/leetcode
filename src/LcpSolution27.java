public class LcpSolution27 {

}

class BlackBox {
    boolean[] state;
    int[] clock;
    int[] anticlock;

    BlackBox(int n, int m) {
        int cnt = 2 * (m + n);
        state = new boolean[cnt];
        clock = new int[cnt];
        anticlock = new int[cnt];
        for (int index = 0; index < cnt; index++) {
            clock[index] = (cnt - index + cnt) % cnt;
            anticlock[index] = (2 * m - index + cnt) % cnt;
            state[index] = false;
        }
    }

    public int open(int index, int direction) {
        int I = index;
        state[index] = true;
        if (direction == 1)
            index = clock[index];
        else
            index = anticlock[index];
        direction *= -1;
        while (!state[index]) {
            if (clock[index] == index || anticlock[index] == index)
                return I;
            if (direction == 1)
                index = clock[index];
            else
                index = anticlock[index];
            direction *= -1;
        }

        return index;
    }

    public void close(int index) {
        state[index] = false;
    }
}
