public class Solution48 {

    public void rotate(int[][] matrix) {
        // 第一步，对称
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                matrix[i][j] += matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];
            }
        }
        //第二部，交换
        for(int i = 0; i < matrix.length / 2; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[j][i] = matrix[j][matrix.length - 1 - i] + matrix[j][i];
                matrix[j][matrix.length - 1 - i] = matrix[j][i] - matrix[j][matrix.length - 1 - i];
                matrix[j][i] = matrix[j][i] - matrix[j][matrix.length - 1 - i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution48 solu = new Solution48();
        solu.rotate(test);
        System.out.println(test);
    }
}
