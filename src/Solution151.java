import java.util.*;

public class Solution151 {

    public String reverseWords(String s) {
        StringBuffer buf = new StringBuffer();
        List<String> list = new ArrayList<>();
        int begin = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(begin == -1) begin = i;
            }else{
                if(begin != -1) list.add(s.substring(begin, i));
                begin = -1;
            }
        }
        if(begin != -1) list.add(s.substring(begin, s.length()));
        for (int i = list.size() - 1; i > 0 ; i--) {
            buf.append(list.get(i));
            buf.append(' ');
        }
        if(list.size() > 0) buf.append(list.get(0));
        return buf.toString();
    }

    public String reverseWords2(String s) {
        StringBuffer buf = new StringBuffer();
        int end = -1;
        for(int i = s.length() -1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                if(end == -1) end = i;
            }else{
                if(end != -1){
                    buf.append(s.substring(i + 1, end + 1));
                    buf.append(' ');
                }
                end = -1;
            }
        }
        if(end != -1){
            buf.append(s.substring(0, end + 1));
            buf.append(' ');
        }
        if(buf.length() > 0) buf.deleteCharAt(buf.length() - 1);
        return buf.toString();
    }

    public static void main(String[] args) {
        Solution151 solu = new Solution151();
        String test = "the sky is blue";
//        String test = "  hello world!  ";
        System.out.println(solu.reverseWords2(test));
    }

}
