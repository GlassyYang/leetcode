import java.util.*;

public class Solution42 {

    public int trap(int[] height) {
        if(height == null || height.length == 0)return 0;
        int borderi = 0;
        int container = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] >= height[borderi])borderi = i;
            else{
                container += height[borderi] - height[i];
            }
        }
        return container;
    }

}
