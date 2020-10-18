import java.util.*;

public class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord)) return 0;
        List<String>[] list = new List[2];
        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>();
        int index = 0;
        int opposite = 1;
        int level = 1;
        list[index].add(beginWord);
        while(!list[index].isEmpty()){
            level++;
            list[opposite].clear();
            for(int i = 0; i < list[index].size(); i++){
                String temp = list[index].get(i);
                wordList.remove(temp);
                for(String word : wordSet){
                    int sum = 0;
                    for(int j = 0; j < word.length(); j++){
                        if(temp.charAt(j) != word.charAt(j)){
                            sum++;
                            if(sum > 1) break;
                        }
                    }
                    if(sum == 1){
                        if(word.equals(endWord)) return level;
                        list[opposite].add(word);
                    }
                }
                wordSet.removeAll(list[opposite]);
            }
            index = index + opposite;
            opposite = index - opposite;
            index = index - opposite;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        Solution127 solu = new Solution127();
        System.out.println(solu.ladderLength(beginWord, endWord, wordList));
    }

}
