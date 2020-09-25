import java.util.LinkedList;
import java.util.Queue;

public class Solution10 {
    // 得用栈
    public static boolean isMatch(String s, String p) {
        int si = 0;
        int pi = 0;
        Queue<Character> sta = new LinkedList<>();
        while (si < s.length() && pi < p.length()) {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                if (p.charAt(pi) == '.') {
                    sta.add(s.charAt(si));
                    si++;
                } else if (p.charAt(pi) == s.charAt(si)) {
                    sta.add(p.charAt(pi));
                    si++;
                } else {
                    int temp = pi;
                    pi++;
                    while (pi < p.length() && p.charAt(pi) == '*') {
                        pi++;
                    }
                    while (pi < p.length() && p.charAt(pi) == p.charAt(temp)) {
                        if (sta.peek() != p.charAt(pi)) {
                            return false;
                        }
                        pi++;
                    }
                }
            } else if (p.charAt(pi) == '.') {
                si++;
                pi++;
            } else if (p.charAt(pi) != s.charAt(si)) {
                return false;
            } else {
                pi++;
                si++;
            }
        }
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
            pi++;
            while (pi < p.length() && p.charAt(pi) == '*') {
                pi++;
            }
        }
        while (pi < p.length() && sta.size() != 0) {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                pi++;
                while (p.charAt(pi) == '*') {
                    pi++;
                }
            } else if (p.charAt(pi) == sta.peek() || p.charAt(pi) == '.') {
                pi++;
                sta.poll();
            } else {
                return false;
            }
        }
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
            pi++;
            while (pi < p.length() && p.charAt(pi) == '*') {
                pi++;
            }
        }
        if (si >= s.length() && pi >= p.length()) {
            return true;
        }
        return false;
    }

    public static void main(String argv[]) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
    }
}
