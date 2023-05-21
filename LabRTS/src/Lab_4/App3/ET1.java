package Lab_4.App3;

public class ET1 extends Thread{
    Integer monitor1;

    int sleep_min, sleep_max, activity_min, activity_max;

    public ET1(Integer monitor1, int sleep_min, int

            sleep_max, int activity_min, int activity_max) {

        this.monitor1 = monitor1;
        this.sleep_min = sleep_min;

        this.sleep_max = sleep_max;

        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    public void run()
    {
        while(true)
        {
            System.out.println(this.getName() + " - STATE 0");
            synchronized(monitor1) {
                System.out.println(this.getName() + " - STATE 1");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName() + " - STATE 2");
            try
            {
                Thread.sleep(Math.round(Math.random() * sleep_min) * 500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 3");

        }
    }
}

