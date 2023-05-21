package Lab_7.App2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Fir extends Thread {

    CyclicBarrier barrier;
    int sum;
    int id;

    public Fir(CyclicBarrier barrier, int sum, int id) {
        this.barrier = barrier;
        this.sum = sum;
        this.id = id;
    }

    public void run() {
        Random random = new Random();
        int i = 1;
        while (true) {
            int num = random.nextInt(21) - 10;
            sum += num;
            System.out.println("sum: "+sum);
            System.out.println("iteration: "+i+ " from thread: " + id);
            i++;
            if(sum == 0)
            {

                System.exit(0);
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            num = random.nextInt(21) - 10;
            sum += num;
            System.out.println("sum: "+sum);
            System.out.println("iteration: "+i);
            i++;
            if(sum == 0)
            {
                System.exit(0);
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("Barrier Routine");
            }
        });
        int s = 0;
        Fir fir1 = new Fir(barrier, s, 0);
        Fir fir2 = new Fir(barrier, s, 1);
        Fir fir3 = new Fir(barrier, s, 2);
        fir1.start();
        fir2.start();
        fir3.start();
    }
}

