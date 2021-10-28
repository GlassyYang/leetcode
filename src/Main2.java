public class Main2 {

    public static boolean reverse(int a) {
        int count = 0;
        while (a > 0) {
            count *= 10;
            count += a % 10;
            a /= 10;
            if(a == count) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 121;
//        System.out.println(a == reverse(a));
    }

}
