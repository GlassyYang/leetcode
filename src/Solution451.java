import java.util.*;

public class Solution451 {

    public String frequencySort(String s) {
        Map<Integer, Set<Character>> frequencies = new TreeMap<>();
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int oldFrequency = characterFrequency.getOrDefault(c, 0), newFrequency = oldFrequency + 1;
            if(oldFrequency != 0) {
                Set<Character> set = frequencies.get(oldFrequency);
                set.remove(c);
            }
            Set<Character> set = frequencies.getOrDefault(newFrequency, new HashSet<>());
            set.add(c);
            frequencies.put(newFrequency, set);
            characterFrequency.put(c, newFrequency);
        }
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer, Set<Character>> frequency : frequencies.entrySet()) {
            for(char c : frequency.getValue()) {
                for(int i = 0; i < frequency.getKey(); ++i) {
                    builder.append(c);
                }
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution451 solution451 = new Solution451();
        System.out.println(solution451.frequencySort("tree"));
    }

}
