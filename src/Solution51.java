import java.lang.reflect.Array;
import java.util.*;

public class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(chessboard[i], '.');
        }
        Stack<Integer> stai = new Stack<>();
        Stack<Integer> staj = new Stack<>();
        stai.push(0);
        staj.push(0);
        chessboard[0][0] = 'Q';
        StringBuilder builder = new StringBuilder(n);
        int i = 0, j = 0;
        while(!stai.isEmpty() || i < chessboard.length){
            while(i < chessboard.length){
                if(canSetHere(chessboard, i, j)){
                    stai.push(i);
                    staj.push(j);
                    chessboard[i][j] = 'Q';
                }
                j++;
                if(j >= chessboard.length){
                    j = 0;
                    i++;
                }
            }
            if(stai.size() == n){
                List<String> list = new ArrayList<>(n);
                for (int k = 0; k < chessboard.length; k++) {
                    builder.setLength(0);
                    for (int l = 0; l < chessboard.length; l++) {
                        builder.append(chessboard[k][l]);
                    }
                    list.add(builder.toString());
                }
                ans.add(list);
            }
            if(i >= chessboard.length && !stai.isEmpty()){
                i = stai.pop();
                j = staj.pop();
                chessboard[i][j] = '.';
                j++;
                if(j >= chessboard.length){
                    j = 0; i++;
                }
            }
        }
        return ans;
    }

    public boolean canSetHere(char[][] chessboard, int i, int j){
        for (int k = 0; k < chessboard.length; k++) if(chessboard[i][k] == 'Q') return false;
        for (int k = 0; k < chessboard.length; k++) if(chessboard[k][j] == 'Q') return false;
        int ip = i > j ? i - j : 0;
        int jp = i > j ? 0 : j - i;
        while(ip < chessboard.length && jp < chessboard.length){
            if(chessboard[ip][jp] == 'Q') return false;
            ip++;
            jp++;
        }
        ip = i + j < chessboard.length ? 0 : i - (chessboard.length - j - 1);
        jp = i + j < chessboard.length ? i + j : chessboard.length - 1;
        while(ip < chessboard.length && jp >= 0){
            if(chessboard[ip][jp] == 'Q') return false;
            ip++;
            jp--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 solu = new Solution51();
        System.out.println(solu.solveNQueens(4));
    }

}
