package Lab_2;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import Lab_2.Fir;

public class Window extends JFrame implements Observer {
    ArrayList<JProgressBar> bars = new ArrayList<JProgressBar>();

    public Window(int nrThreads) {
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            add(pb);
            bars.add(pb);
        }
    }

    public void update(java.util.Observable o, Object arg) {
        JProgressBar progbarr = bars.get(((Fir) o).id);
        progbarr.setValue(progbarr.getValue() + 1);
    }


}