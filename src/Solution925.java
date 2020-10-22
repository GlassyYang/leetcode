public class Solution925 {


    public boolean isLongPressedName(String name, String typed) {
        if(name == null && typed== null) return true;
        if(name == null || typed == null || typed.length() < name.length()) return false;
        int index = 0;
        for(int i = 0; i < typed.length(); i++){
            if(index < name.length() && typed.charAt(i) == name.charAt(index)) index++;
            else if(index <= 0 || typed.charAt(i) != name.charAt(index - 1)) return false;
        }
        return index >= name.length();
    }

    public static void main(String[] args) {
        String name = "pyplrz", typed = "ppyypllr";
        Solution925 solu = new Solution925();
        System.out.println(solu.isLongPressedName(name, typed));
    }

}
