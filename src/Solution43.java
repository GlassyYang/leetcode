import java.util.*;

public class Solution43 {

    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return num1;
        int[] buf = new int[num1.length() + num2.length()];
        int[] add1 = new int[num1.length()], add2 = new int[num2.length()];
        for(int i = 0; i < num1.length(); i++) add1[i] = num1.charAt(i) - '0';
        for(int i = 0; i < num2.length(); i++) add2[i] = num2.charAt(i) - '0';
        Arrays.fill(buf, 0);
        int carry = 0;
        int cur = 0;
        int index = 0;
        for(int i = add2.length - 1; i >= 0; i--){
            carry = 0;
            index = buf.length - (add2.length - i);
            for(int j = add1.length - 1; j >= 0; j--){
                cur = add1[j] * add2[i] + carry + buf[index];
                if(cur > 9){
                    carry = cur / 10;
                    cur = cur % 10;
                }else carry = 0;
                buf[index--] = cur;
            }
            while(carry != 0){
                cur = buf[index] + carry;
                if(cur > 9){
                    carry = cur / 10;
                    cur = cur % 10;
                }else carry = 0;
                buf[index--] = cur;
            }
        }
        //将buf中的数字转换成字符串就ok了。
        StringBuilder builder = new StringBuilder();
        while(index < buf.length && buf[index] == 0) index++;
        if(index >= buf.length) return "0";
        while(index < buf.length) builder.append((char)('0' + buf[index++]));
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution43 solu = new Solution43();
        System.out.println(solu.multiply("2", "3"));

    }

}
