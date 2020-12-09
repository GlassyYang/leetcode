import java.util.*;

public class Solution30 {

    static class Trie {
        String str;
        Map<Character, Trie> childs;

        public Trie() {
            this.str = null;
            this.childs = new HashMap<>();
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 第一步，构建树
        Trie trie = new Trie(), cur, temp;
        String word;
        char c;
        List<Integer> ans = new LinkedList<>();
        Map<String, Integer> template = new HashMap<>(words.length);
        Map<String, Integer> hash = new HashMap<>(words.length);
        int flag = words.length;
        for (int i = 0; i < words.length; i++) {
            word = words[i];
            if(template.containsKey(word))
                template.put(word, template.get(word) + 1);
            else template.put(word, 1);
            cur = trie;
            for (int j = 0; j < word.length(); j++) {
                c = word.charAt(j);
                if (!cur.childs.containsKey(c)) {
                    temp = new Trie();
                    cur.childs.put(c, temp);
                    cur = temp;
                } else
                    cur = cur.childs.get(c);
            }
            cur.str = word;
        }
        //树构建完了之后开始匹配
        for (int i = 0; i < s.length(); i++) {
            flag = words.length;
            for (String str: template.keySet())
                hash.put(str, template.get(str));
            cur = trie;
            int j = i;
            while (j < s.length()) {
                c = s.charAt(j);
                if (cur.childs.containsKey(c)) {
                    cur = cur.childs.get(c);
                    if (cur.str != null) {
                        int tempi = hash.get(cur.str);
                        if (tempi <= 0) break;
                        hash.put(cur.str, --tempi);
                        flag--;
                        cur = trie;
                    }
                    if (flag == 0) {
                        ans.add(i);
                        break;
                    }
                } else
                    break;
                j++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        Solution30 solu = new Solution30();
        System.out.println(solu.findSubstring(s, words));
    }

}
