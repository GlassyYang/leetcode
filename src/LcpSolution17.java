public class LcpSolution17 {

    public int calculate(String s) {
        int x = 1, y = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    x = 2 * x + y;
                    break;
                case 'B':
                    y = 2 * y + x;
                    break;
            }
        }
        return x + y;
    }

}
