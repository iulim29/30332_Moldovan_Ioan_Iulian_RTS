package Lab_5.App4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fir extends Thread{
    int name, activity_max, activity_min, sleep_min;
    Lock l1, l2;
    Fir(int n, Lock l1, Lock l2, int ama, int ami, int sl)
    {
        name = n;
        this.l1 = l1;
        this.l2 = l2;
        this.activity_max = ama;
        this. activity_min = ami;
        this.sleep_min = sl;
    }
    public void run()
    {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++)
        {
            i++;
            i--;
        }
        if(l1.tryLock())
        {
            try{
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min + 2);
                for (int i = 0; i < k * 100000; i++)
                {
                    i++;
                    i--;
                }
                if(l2.tryLock())
                {
                    try{
                        System.out.println(this.getName() + " - STATE 3");
                        try
                        {
                            Thread.sleep(Math.round(Math.random() * sleep_min) * 500);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    finally {
                        this.l2.unlock();
                    }
                }
            }
            finally {
                this.l1.unlock();
            }
        }
        System.out.println(this.getName() + " - STATE 4");

    }
}
public class Main {
    public static void main(String[] args)
    {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        Fir f1 = new Fir(1, l1, l2, 2, 4, 4);
        Fir f2 = new Fir(2, l2, l1, 3, 5, 5);
        f1.start();
        f2.start();
    }
}
