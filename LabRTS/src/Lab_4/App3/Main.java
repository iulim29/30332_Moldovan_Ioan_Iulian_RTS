package Lab_4.App3;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        new ET1(monitor1, 5, 5, 3, 6).start();
        new ET1(monitor1, 3, 3, 4, 7).start();
        new ET1(monitor1, 6, 6, 5, 7).start();

    }
}