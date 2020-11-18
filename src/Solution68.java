import java.util.*;

public class Solution68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int len = 0;
        int spaceN = 0;
        int spaceMod = 0;
        StringBuffer buf = new StringBuffer(maxWidth);
        for(int i = 0; i < words.length; i++){
            if(len + words[i].length() > maxWidth){
                buf.setLength(0);
                if(start + 1 == i){
                    buf.append(words[start]);
                    while(len <= maxWidth){
                        buf.append(' ');
                        len++;
                    }
                    ans.add(buf.toString());
                }else{
                    int temp = i - start - 1;
                    spaceN = (maxWidth - len + temp + 1) / temp;
                    spaceMod = (maxWidth - len + temp + 1) % temp;
                    while(start < i - 1){
                        buf.append(words[start]);
                        int space = spaceMod > 0 ? spaceN + 1 : spaceN;
                        for(int j = 0; j < space; j++) buf.append(' ');
                        spaceMod--;
                        start++;
                    }
                    buf.append(words[i - 1]);
                    ans.add(buf.toString());
                }
                len = words[i].length() + 1;
                start = i;
            }else{
                len += words[i].length() + 1;
            }
        }
        buf.setLength(0);
        len = 0;
        while(start < words.length - 1){
            buf.append(words[start]);
            buf.append(' ');
            len += words[start].length() + 1;
            start++;
        }
        buf.append(words[words.length - 1]);
        len += words[words.length - 1].length();
        while(len < maxWidth){
            buf.append(' ');
            len++;
        }
        ans.add(buf.toString());
        return ans;
    }

    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        Solution68 solu = new Solution68();
        System.out.println(solu.fullJustify(words, 16));
    }

}
