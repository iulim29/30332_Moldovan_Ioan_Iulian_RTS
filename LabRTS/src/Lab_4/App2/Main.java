package Lab_4.App2;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread1(monitor1, monitor2, 4, 4, 2, 4).start();
        new ExecutionThread1(monitor2, monitor1, 5, 5, 3, 6).start();
    }
}
