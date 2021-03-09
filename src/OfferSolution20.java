public class OfferSolution20 {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int c = s.charAt(s.length() - 1);
        if (c == 'e' || c == 'E') return false;
        String[] parts = s.split("E|e");
        if (parts.length > 2) return false;
        if (parts.length == 2) {
            if (!isDigit(parts[0])) return false;
            if (!isInt(parts[1])) return false;
        } else {
           if (!isDigit(parts[0])) return false;
        }
        return true;
    }

    public boolean isInt(String s) {
        if (s.length() == 0) return false;
        boolean ans = true;
        char c = s.charAt(0);
        int index = 0;
        if (c == '+' || c == '-') {
            index++;
            if (s.length() == 1) return false;
        }
        while (index < s.length()) {
            c = s.charAt(index);
            if (c < '0' || c > '9') return false;
            index++;
        }
        return true;
    }

    public boolean isDigit(String s) {
        if (s.length() == 0) return false;
        boolean dot = false, left = false, right = false;
        int index = 0;
        char c = s.charAt(index);
        if (c == '+' || c == '-') {
            index++;
            if (s.length() == 1) return false;
        }
        while (index < s.length()) {
            c = s.charAt(index++);
            if (c == '.') {
                if (!dot) {
                    dot = true;
                    continue;
                }
                else return false;
            }
            if (c < '0' || c > '9') return false;
            if (dot) right = true;
            else left = true;
        }
        if (dot && !right && !left) return false;
        return true;
    }

    public static void main(String[] args) {
        OfferSolution20 solu = new OfferSolution20();
        System.out.println(solu.isDigit(".14159"));
    }

}
