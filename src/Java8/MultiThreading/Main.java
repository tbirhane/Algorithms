package Java8.MultiThreading;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Thread with Runnable interface
        Runnable task2 = () -> {
            System.out.println("Task 2 with Rannable");
            System.out.println(Thread.currentThread().getName());
        };
        //Task with Callable
        Callable<Integer> task3 = () -> {
            System.out.println("Task 3 with Callable: "+Thread.currentThread().getName());
            return 120;
        };

        Task1WithThreadClass runTask1 = new Task1WithThreadClass();
        runTask1.start();
        //or
        Thread tread1 = new Thread(new Task1WithThreadClass());
        tread1.start();
        //java 8
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(task2);
        Future<Integer> val = service.submit(task3);
        System.out.println(val.isDone());
        if(val.isDone())
        System.out.println(val.get());

    }
}
