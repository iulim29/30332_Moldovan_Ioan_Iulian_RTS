package Lab_2;
import java.util.Observable;

public class Fir extends Observable implements Runnable {
    public int id;
    int processorLoad;
    Window win;
    int priority;

    public Fir(int id, int i, Window win, int procLoad) {
        this.id = id;
        this.win = win;
        this.priority = i;
        this.addObserver(win);
        this.processorLoad = procLoad;
    }

    public void run() {
        int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(priority);
        t.start();
    }
}