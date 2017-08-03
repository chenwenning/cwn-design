package list;

/**
 * Created by chenwenning on 2017/7/31.
 */
public class test2 {

    public static void main(String[] args) {
        int n = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i = i + 2) {
            if (i > 3) {
                if (isPrimeNumber(i)) {
                    System.out.println(i);
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    public static boolean isPrimeNumber(int a) {
        boolean flag = true;
        int temp = (int) Math.sqrt(a);
        if (a % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= temp; i = i + 2) {
            if (a % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
