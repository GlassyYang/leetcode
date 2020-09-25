public class Solution7 {

    public static int reverse(int x) {
    String is = Integer.toString(x);
    int ans = 0;
    int end = 0;
    int begin = is.length() - 1;
    if(is.charAt(0) == '-'){
        end = 1;
    }
    for(int i = begin; i >= end; i--){
        if(ans * 10 / 10 != ans){
            return 0;
        }
        ans *= 10;
        if(ans + is.charAt(i) - '0' < ans){
            return 0;
        }
        ans += is.charAt(i) - '0';
    }
    if(end == 1){
        ans = -ans;
    }
    return ans;
    }

    public static void main(String argv[]){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(reverse(1534236469));
    }
}
