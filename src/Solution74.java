public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0, end = matrix.length * matrix[0].length;
        int mid = (start + end) / 2;
        while(start < mid){
            if(getI(matrix, mid) < target)
                start = mid;
            else if(getI(matrix, mid) > target)
                end = mid;
            else
                return true;
            mid = (start + end) / 2;
        }
        return false;
    }

    public int getI(int[][] matrix, int index){
        int x = index / matrix[0].length, y = index % matrix[0].length;
        return matrix[x][y];
    }

}
