public class Solution344 {

    public void reverseString(char[] s) {
        if(s == null) return;
        char temp = '\0';
        for(int i = 0; i < s.length / 2; i++){
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
