public class Solution58 {

    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        s = s.strip();
        int length = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') length++;
            else length = 0;
        }
        return length;
    }

}
