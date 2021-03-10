import java.util.*;

public class Solution224 {

    public int calculate(String s) {
        Stack<Integer> sta = new Stack<>();
        Stack<Character> op = new Stack<>();
        int ans = 0, number = 0;
        char operator = '\00';
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            switch (c) {
                case '+':
                    if (operator !='\00' ) {
                        if (operator == '+') {
                            ans += number;
                        } else {
                            ans -= number;
                        }
                        operator = '+';
                        number = 0;
                    } else {
                        operator = '+';
                        ans = number;
                        number = 0;
                    }
                    break;
                case '-':
                    if (operator != '\00') {
                        if (operator == '+') {
                            ans += number;
                        } else {
                            ans -= number;
                        }
                        operator = '-';
                        number = 0;
                    } else {
                        operator = '-';
                        ans = number;
                        number = 0;
                    }
                    break;
                case ' ':
                    break;
                case '(':
                    sta.push(ans);
                    op.push(operator);
                    ans = 0;
                    operator = '\00';
                    break;
                case ')':
                    switch (operator) {
                        case '+':
                            ans += number;
                            break;
                        case '-':
                            ans -= number;
                            break;
                        default:
                            ans = number;
                    }
                    operator = op.pop();
                    number = ans;
                    ans = sta.pop();
                    break;
                default:
                    number *= 10;
                    number += c - '0';
            }
        }
        if (number != 0) {
            switch (operator) {
                case '+':
                    ans += number;
                    break;
                case '-':
                    ans -= number;
                    break;
                default:
                    ans = number;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution224 solu = new Solution224();
        System.out.println(solu.calculate("(2-(1 + 2))"));
    }

}
