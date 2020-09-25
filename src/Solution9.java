public class Solution9 {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int ans = 0;
        int copy = x;
        while(copy > 0){
            ans *= 10;
            ans += copy % 10;
            copy /= 10;
        }
        return ans == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1011));
    }
}
