package Lab4.App4;

public class Main {
    public static void main(String[] args) {
        Integer monitorP6 = 0;
        Integer monitorP10 = 1;

        Integer monitorP2 = 2;
        Integer monitorP5 = 3;
        Integer monitorP9 = 4;

        int[] activity1 = { 2, 3 };
        int[] activity2 = { 3, 5 };
        int[] activity3 = { 4, 6 };



        new ExecutionThread(7,monitorP6, monitorP10, monitorP2, monitorP5, monitorP9, activity1, activity2, activity3).start();
        new ExecutionThread(0,monitorP6, monitorP10, monitorP2, monitorP5, monitorP9, activity1, activity2, activity3).start();
        new ExecutionThread(0,monitorP6, monitorP10, monitorP2, monitorP5, monitorP9, activity1, activity2, activity3).start();
    }
}
