import com.sun.tools.jconsole.JConsoleContext;

public class Solution896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;
        int index = 1;
        while (A[index - 1] == A[index] && index < A.length) index++;
        if (index >= A.length) return true;
        boolean flag = A[index - 1] <= A[index];
        while(index < A.length) {
            if (flag && A[index - 1] > A[index]) return false;
            if (!flag && A[index - 1] < A[index]) return false;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution896 solution = new Solution896();
        System.out.println(solution.isMonotonic(new int[]{1, 2, 2, 3}));
    }
}
