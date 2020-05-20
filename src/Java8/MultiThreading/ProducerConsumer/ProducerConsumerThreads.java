package Java8.MultiThreading.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerThreads {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Runnable producerThread = () ->{
            try {
                producerConsumer.produce();
            }catch (InterruptedException e){
            }
        };
        Runnable consumerThread = () -> {
            try{
                producerConsumer.consume();
            } catch (InterruptedException e){

            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(producerThread);
        executorService.submit(consumerThread);
//        Thread t1 = new Thread(producerThread);
//        Thread t2 = new Thread(consumerThread);
//        t1.start();
//        t2.start();


    }
}
