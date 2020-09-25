import java.util.*;

public class Solution93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Stack<String> sta = new Stack<>();
        search(s, 0, sta, ans, builder);
        return ans;
    }

    public static void search(String s, int index, Stack<String> sta, List<String> ans, StringBuilder builder) {
        if (index < s.length()) {
            int pre = -1;
            if (s.charAt(index) == '0') {
                if (sta.size() == 3) {
                    if (index != s.length() - 1) return;
                    builder.setLength(0);
                    for (String e : sta) {
                        builder.append(e);
                        builder.append('.');
                    }
                    builder.append(Integer.toString(0));
                    ans.add(builder.toString());
                } else {
                    sta.push("0");
                    search(s, index + 1, sta, ans, builder);
                    sta.pop();
                }
            }else{
                    for (int i = index + 1; i <= s.length(); i++) {
                        int temp = Integer.parseInt(s.substring(index, i));
                        if (temp == pre) break;
                        pre = temp;
                        if (temp <= 255) {
                            if (sta.size() == 3) {
                                if (i != s.length()) continue;
                                builder.setLength(0);
                                for (String e : sta) {
                                    builder.append(e);
                                    builder.append('.');
                                }
                                builder.append(Integer.toString(temp));
                                ans.add(builder.toString());
                            } else {
                                sta.push(Integer.toString(temp));
                                search(s, i, sta, ans, builder);
                                sta.pop();
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        public static void main (String[]args){
            System.out.println(restoreIpAddresses("010010"));
//        System.out.println(Integer.parseInt("001234"));
        }

    }
