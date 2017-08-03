package list;

/**
 * Created by chenwenning on 2017/7/31.
 * 求质数算法
 */
public class Prime1 {


    public static void main(String[] args) {
        int n = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
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
        for (int i = 2; i <= temp; i++) {
            if (a % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
