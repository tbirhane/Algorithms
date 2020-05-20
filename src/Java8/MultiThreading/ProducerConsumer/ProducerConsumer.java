package Java8.MultiThreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue<Integer> queue = new LinkedList<>();
    static final int size = 4;

    public void produce() throws InterruptedException{
        int value=0;
        while(true) {
            synchronized (this) {
                while (queue.size() == size) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + "Produced: " + value);
                queue.add(value++);

                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + "Consumed: " + queue.poll());
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
