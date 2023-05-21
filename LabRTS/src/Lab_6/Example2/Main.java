package Lab_6.Example2;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Fir fir1 = new Fir(countDownLatch, "fir 1");
        Fir fir2 = new Fir(countDownLatch, "fir 2");
        Fir fir3 = new Fir(countDownLatch, "fir 3");
        fir1.run();
        fir2.run();
        fir3.run();
    }
}



 class Fir {
    CountDownLatch countDownLatch;
    String name;

    public Fir(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        while (true) {
            activitate1();

            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            activitate2();
        }
    }

    public void activitate1() {
        System.out.println(this.getName() + "> activitate 1");
        try {
            Thread.sleep(Math.round(Math.random() * 3 + 3) * 1000);
        } catch (InterruptedException e) {
        }
    }

    public void activitate2() {
        System.out.println(this.getName() + "> activitate 2");
        try {
            Thread.sleep(Math.round(Math.random() * 3 + 3) * 1000);
        } catch (InterruptedException e) {
        }
    }
}