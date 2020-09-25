import java.util.Arrays;
import java.util.*;
public class Solution16 {

    public static int threeSumClosest(int[] nums, int target) {
        int min = 65535;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target) < min){
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        sum = nums[i] + nums[j] + nums[k];
                        System.out.println(nums[i]);
                        System.out.println(nums[j]);
                        System.out.println(nums[k]);
                    }
                }
            }
        }
        return sum;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] buf = new char[s.length()];
        int max = 0;
        int indexb = 0;
        int indexe = -1;
        for(int i = 0; i < s.length(); i++){
            if((indexe + 1) % s.length() == indexb){
                indexe += 1;
                indexe %= s.length();
                buf[indexe] = s.charAt(i);
            }else if(buf[indexb] == s.charAt(i)){
                int len = 0;
                if(indexe < indexb){
                    len = indexe + s.length() - indexb + 1;
                }else{
                    len = indexe - indexb +1;
                }
                if(len > max){
                    max = len;
                }
                indexb += 1;
                indexb %= s.length();
                indexe += 1;
                indexe %= s.length();
                buf[indexe] = s.charAt(i);
            }else{
                indexe += 1;
                indexe %= s.length();
                buf[indexe] = s.charAt(i);
            }
        }
        int len = 0;
        if(indexe < indexb){
            len = indexe + s.length() - indexb + 1;
        }else{
            len = indexe - indexb +1;
        }
        if(len > max){
            return len;
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int cur = 0;
        int rem = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                if(cur > max){
                    max = cur;
                }
                i = rem;
                cur = 1;
                rem += 1;
                set.clear();
                set.add(s.charAt(i));
            }else{
                cur += 1;
                set.add(s.charAt(i));
            }
        }
        if(cur > max){
            max = cur;
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new TreeSet<Character>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                if(set.size() > max){
                    max = set.size();
                }
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.size() > max){
            max = set.size();
        }
        return max;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 先解决特殊情况
        if(nums1.length == 0){
            if(nums2.length % 2 == 1){
                return nums2[nums2.length / 2];
            }else{
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            }
        }
        if(nums2.length == 0){
            if(nums1.length % 2 == 1){
                return nums1[nums1.length / 2];
            }else{
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            }
        }
        // 开始算法
        int choice = 0;
        int[] index = {0,0};
        int[] length = {nums1.length, nums2.length};
        int[][] nums = {nums1, nums2};
        double medium = 0;
        int[] mediumn;
        if((nums1.length + nums2.length) % 2 == 0) {
            mediumn = new int[2];
            mediumn[0] = (nums1.length + nums2.length) / 2 - 1;
            mediumn[1] = (nums1.length + nums2.length) / 2;
        }else{
            mediumn = new int[1];
            mediumn[0] = (nums1.length + nums2.length) / 2;;
        }
        int count = 0;
        while(count < nums1.length + nums2.length){
            if(index[0] <length[0] && index[1] < length[1]){
                if(nums[0][index[0]] < nums[1][index[1]]){
                    if(count == mediumn[0]){
                        medium += nums[0][index[0]];
                    }else if(mediumn.length == 2 && count == mediumn[1]){
                        medium += nums[0][index[0]];
                    }
                    index[0] += 1;
                }else{
                    if(count == mediumn[0]){
                        medium += nums[1][index[1]];
                    }else if(mediumn.length == 2 && count == mediumn[1]){
                        medium += nums[1][index[1]];
                    }
                    index[1] += 1;
                }
            }else if(index[0] < length[0]){
                if(count == mediumn[0]){
                    medium += nums[0][index[0]];
                }else if(mediumn.length == 2 && count == mediumn[1]){
                    medium += nums[0][index[0]];
                }
                index[0] += 1;
            }else{
                if(count == mediumn[0]){
                    medium += nums[1][index[1]];
                }else if(mediumn.length == 2 && count == mediumn[1]){
                    medium += nums[1][index[1]];
                }
                index[1] += 1;
            }
            count += 1;
        }
        return medium / mediumn.length;
    }

    public static void main(String argv[]){
//        int[] nums = {-1,2,1,-4};
//        int target = 1;
//        int res = threeSumClosest(nums, target);
//        System.out.println(res);
//        String a = "123";
//        String dtr = "pwwkew";
//        System.out.println(lengthOfLongestSubstring3(dtr));
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
