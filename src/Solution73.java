public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        boolean col = matrix[0][0] == 0;
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                matrix[0][0] = 0;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                col = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution73 solu = new Solution73();
        solu.setZeroes(new int[][]{{0}, {1}});
    }

}
