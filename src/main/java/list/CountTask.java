package list;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by chenwenning on 2017/8/2.
 */
public class CountTask extends RecursiveTask {


    private static final long serialVersionUID = -3611254198265061729L;

    public static final int threshold = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (i >= 2) {
                if (isPrimeNumber(i)) {
                    System.out.println(i);
                }
            }
        }
        /*int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                if (i >= 2) {
                    if (isPrimeNumber(i)) {
                        System.out.println(i);
                    }
                }
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            // 执行子任务
            leftTask.fork();//执行子任务
            rightTask.fork();//执行子任务

            leftTask.join(); //等待子任务执行完成

            rightTask.join();//等待子任务执行完成

            //等待任务执行结束合并其结果
            //int leftResult = leftTask.join();
            //int rightResult = rightTask.join();

            //合并子任务
            //sum = leftResult + rightResult;

        }*/

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        int start = 1;
        int end = 1000;
        int middle = (start + end) / 2;
        CountTask leftTask = new CountTask(start, middle);
        CountTask rightTask = new CountTask(middle + 1, end);


        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(leftTask);
        Future<Integer> result2 = forkjoinPool.submit(rightTask);
        leftTask.fork();//执行子任务
        rightTask.fork();//执行子任务

        leftTask.join(); //等待子任务执行完成

        rightTask.join();//等待子任务执行完成
        try {
            System.out.println(result.get());
            System.out.println(result2.get());
            System.out.println("看看是否会阻塞");
        } catch (Exception e) {
            System.out.println(e);
        }
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
