package Lab_5.App5;

import java.util.concurrent.Semaphore;

class Fir extends Thread{
    int name, delay, ama, ami, permit;
    Semaphore s;
    Fir(int n, int d, int ama, int ami, Semaphore s, int permit)
    {
        name = n;
        delay = d;
        this.ama = ama;
        this.ami = ami;
        this.s = s;
        this.permit = permit;

    }
    public void run()
    {
        while(true)
        {
            try{
                System.out.println(name + " State 1");
                s.acquire(permit);
                System.out.println(name + " State 2");
                int k = (int) Math.round(Math.random()*(ama - ami) + ami);
                for(int i = 0; i < k * 100000; i++)
                {
                    i++;
                    i--;
                }
                s.release();
                System.out.println(name + " State 3");
                Thread.sleep(delay * 500);
                System.out.println(name + " State 4");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    public static void main(String[] args)
    {
        Semaphore s = new Semaphore(2);
        Fir f1, f2, f3;
        f1 = new Fir(1, 5, 6, 3, s, 1);
        f2 = new Fir(2, 3, 7, 4, s, 1);
        f3 = new Fir(3, 6, 7, 5, s, 1);
        f1.start();
        f2.start();
        f3.start();
    }
}