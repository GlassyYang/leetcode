public class Solution201 {

    public int rangeBitwiseAnd(int m, int n) {
        int bitAnd = m,  mask = 0x01;
        for(int i = 0; i < 32; i++){
            if((bitAnd & mask) != 0){

            }
        }
        return bitAnd;
    }

    public static void main(String[] args) {
        Solution201 solu = new Solution201();
        System.out.println(solu.rangeBitwiseAnd(0, 2147483647));
    }

}
