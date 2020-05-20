package Java8.MultiThreading.ProducerConsumerUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduceConsume {
    public static void main(String[] args) {
        var x = 10;
        var str = "Hello";

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Runnable producerThread = () ->{
            try {
                int i=0;
                while(true){
                    System.out.println(Thread.currentThread().getName()+" Produced "+ i);
                    queue.put(i++);
                    Thread.sleep(1000);
                }

            }catch (InterruptedException e){
            }
        };
        Runnable consumerThread = () -> {
            try{
                while(true){
                    System.out.println(Thread.currentThread().getName()+ " Consumed "+ queue.take());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){

            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(producerThread);
        executorService.submit(consumerThread);
    }
}
