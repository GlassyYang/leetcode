import java.util.*;

public class Solution71 {

    public String simplifyPath(String path) {
        if(path.length() == 0) return path;
        StringBuilder builder = new StringBuilder();
        Stack<String> sta = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/' && builder.length() != 0) {
                String temp = builder.toString();
                builder.setLength(0);
                if (temp.equals("..")) {
                    if (!sta.isEmpty()) {
                        sta.pop();
                    }
                } else if (!temp.equals(".")) {
                    sta.push(temp);
                }
            }else if(path.charAt(i) != '/'){
                builder.append(path.charAt(i));
            }
        }
        if(builder.length() != 0){
            String temp = builder.toString();
            if (temp.equals("..")) {
                if (!sta.isEmpty()) {
                    sta.pop();
                }
            } else if (!temp.equals(".")) {
                sta.push(temp);
            }
        }
        builder.setLength(0);
        for(String e : sta){
            builder.append('/');
            builder.append(e);
        }
        if(builder.length() == 0) builder.append('/');
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution71 solu = new Solution71();
        System.out.println(solu.simplifyPath(""));
    }

}
