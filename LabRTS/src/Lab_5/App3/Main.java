package Lab_5.App3;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int COLLECTION_CAPACITY = 100;
    private static final ArrayList<Integer> collection = new ArrayList<>(COLLECTION_CAPACITY);
    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();
    private static final Random random = new Random();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    int num = random.nextInt();
                    lock.lock();
                    try {
                        while (collection.size() == COLLECTION_CAPACITY) {
                            notFull.await();
                        }
                        collection.add(num);
                        notEmpty.signalAll();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer1 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (collection.isEmpty()) {
                        notEmpty.await();
                    }
                    int num = collection.get(0);
                    collection.remove(0);
                    System.out.println("Consumer1: " + num);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer2 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (collection.isEmpty()) {
                        notEmpty.await();
                    }
                    int num = collection.get(0);
                    collection.remove(0);
                    System.out.println("Consumer2: " + num);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer3 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (collection.isEmpty()) {
                        notEmpty.await();
                    }
                    int num = collection.get(0);
                    collection.remove(0);
                    System.out.println("Consumer3: " + num);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
