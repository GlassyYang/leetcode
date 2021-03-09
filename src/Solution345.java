import java.util.Arrays;

public class Solution345 {

    public String reverseVowels(String s) {
        char[] buf = new char[s.length()];
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        boolean[] characters = new boolean[26];
        for (int i = 0; i < vowel.length; i++) {
            characters[vowel[i] - 'a'] = true;
        }
        int left = 0, right = s.length() - 1;
        char c;
        int index;
        while (left <= right) {
            while (left <= right) {
                c = s.charAt(left);
                if (Character.isAlphabetic(c)) {
                    index = c <= 'Z' ? c - 'A' : c - 'a';
                    if (characters[index]) break;
                }
                buf[left++] = c;
            }
            while (left <= right) {
                c = s.charAt(right);
                if (Character.isAlphabetic(c)) {
                    index = c <= 'Z' ? c - 'A' : c - 'a';
                    if (characters[index]) break;
                }
                buf[right--] = c;
            }
            if (left <= right) {
                buf[right] = s.charAt(left);
                buf[left] = s.charAt(right);
                left++;
                right--;
            }
        }
        return new String(buf);
    }

    public static void main(String[] args) {
        Solution345 solu = new Solution345();
        System.out.println(solu.reverseVowels("ASED"));
    }

}
