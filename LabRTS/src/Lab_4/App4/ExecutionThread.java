package Lab4.App4;

public class ExecutionThread extends Thread {
    final Integer monitorP6, monitorP10, monitorP2, monitorP5, monitorP9;
    int[] activity1, activity2, activity3;
    int sleep;
    int k = 0;

    public ExecutionThread(int sleep, Integer monitorP6, Integer monitorP10, Integer monitorP2, Integer monitorP5,
            Integer monitorP9, int[] activity1, int[] activity2, int[] activity3) {
        this.monitorP6 = monitorP6;
        this.monitorP10 = monitorP10;
        this.monitorP2 = monitorP2;
        this.monitorP5 = monitorP5;
        this.monitorP9 = monitorP9;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.activity3 = activity3;
        this.sleep = sleep;
    }

    public void run() {
        synchronized (monitorP2) {
            synchronized (monitorP5) {
                synchronized (monitorP9) {
                    if (this.getName().equals("Thread-0")) {
                        System.out.println(this.getName() + " - STATE 1");
                        synchronized (monitorP10) {
                            synchronized (monitorP6) {
                                System.out.println(this.getName() + " - TRANSITION 1 - 2");
                                try {
                                    Thread.sleep(sleep);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println(this.getName() + " - STATE 2");

                                k = (int) Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[0]);
                                for (int i = 0; i < k * 100000; i++) {
                                    i++;
                                    i--;
                                }
                                System.out.println(this.getName() + " - STATE 3");
                            }
                        }
                    }
                    if (this.getName().equals("Thread-1")) {

                        synchronized (monitorP6) {
                            System.out.println(this.getName() + " - TRANSITION 1 - 2");
                            System.out.println(this.getName() + " - STATE 2");
                            k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[0]);
                            for (int i = 0; i < k * 100000; i++) {
                                i++;
                                i--;
                            }
                            System.out.println(this.getName() + " - STATE 3");
                        }
                    }
                    if (this.getName().equals("Thread-2")) {
                        System.out.println(this.getName() + " - TRANSITION 1 - 2");
                        System.out.println(this.getName() + " - STATE 2");
                        synchronized (monitorP10) {
                            k = (int) Math.round(Math.random() * (activity3[1] - activity3[0]) + activity3[0]);
                            for (int i = 0; i < k * 100000; i++) {
                                i++;
                                i--;
                            }
                            System.out.println(this.getName() + " - STATE 3");
                        }
                    }
                }
            }
        }
    }
}
