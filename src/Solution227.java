import java.util.*;

public class Solution227 {
    // 中缀转后缀计算
    public int calculate1(String s) {
        Deque<Integer> numbers = new LinkedList<>();
        Stack<Integer> operators = new Stack<>();
        Deque<Boolean> type = new LinkedList<>();
        int number = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    while (!operators.isEmpty()) {
                        int op = operators.pop();
                        if (op == '*' || op == '/') {
                            numbers.addLast(op);
                            type.addLast(false);
                        } else {
                            operators.push(op);
                            break;
                        }
                    }
                    operators.push(c);
                    if (flag) {
                        numbers.addLast(number);
                        type.addLast(true);
                        number = 0;
                        flag = false;
                    }
                    break;
                case '*':
                case '/':
                    operators.push(c);
                    if (flag) {
                        numbers.addLast(number);
                        type.addLast(true);
                        number = 0;
                        flag = false;
                    }
                    break;
                case ' ':
                    break;
                default:
                    flag = true;
                    number *= 10;
                    number += c - '0';
            }
        }
        numbers.addLast(number);
        type.addLast(true);
        while (!operators.isEmpty()) {
            numbers.addLast(operators.pop());
            type.addLast(false);
        }
        int left = 0, right = 0;
        while (!numbers.isEmpty()) {
            boolean ctype = type.poll();
            number = numbers.poll();
            if (ctype) {
                operators.push(number);
            } else {
                right = operators.pop();
                left = operators.pop();
                switch (number) {
                    case '+':
                        operators.push(left + right);
                        break;
                    case '-':
                        operators.push(left - right);
                        break;
                    case '*':
                        operators.push(left * right);
                        break;
                    case '/':
                        operators.push(left / right);
                        break;
                }
            }
        }
        return operators.pop();
    }

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1-1+1";
        Solution227 solu = new Solution227();
        System.out.println(solu.calculate(s));
    }

}
