import java.util.*;

public class Solution13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'V'){
                    ans -= 1;
                } else if(i + 1 < s.length() && s.charAt(i + 1) == 'X'){
                    ans -= 1;
                }else{
                    ans += 1;
                }
            }else if(s.charAt(i) == 'X'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'L'){
                    ans -= 10;
                } else if(i + 1 < s.length() && s.charAt(i + 1) == 'C'){
                    ans -= 10;
                }else{
                    ans += 10;
                }

            }else if(s.charAt(i) == 'C'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'D'){
                    ans -= 100;
                } else if(i + 1 < s.length() && s.charAt(i + 1) == 'M'){
                    ans -= 100;
                }else{
                    ans += 100;
                }

            }else{
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
