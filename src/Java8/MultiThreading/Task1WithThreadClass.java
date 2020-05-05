package Java8.MultiThreading;

public class Task1WithThreadClass extends Thread {
@Override
    public void run(){
    System.out.println("Task1 with thread class");
    System.out.println(Thread.currentThread().getName());
}
}
