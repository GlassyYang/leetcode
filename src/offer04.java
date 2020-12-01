public class offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args) {
        offer04 solu = new offer04();
        int[][] matrix = {{1, 4}, {2, 5}};
        System.out.println(solu.findNumberIn2DArray(matrix, 4));
    }

}
