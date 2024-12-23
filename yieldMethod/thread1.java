package yieldMethod;

public class thread1 extends Thread{
    public void run(){
        String name=Thread.currentThread().getName();
        for (int i=1;i<=3;i++){
            System.out.println(name);
            Thread.yield();
        }
    }
}
class thread2 extends Thread{
    public void run(){
        String name=Thread.currentThread().getName();
        for (int i=1;i<=3;i++){
            System.out.println(name);
        }
    }
}
class B{
    public static void main(String[] args) {
        thread1 th1=new thread1();
        thread2 th2=new thread2();

        th1.setName("Thread 1");
        th2.setName("Thread 2");

        th1.start();
        th2.start();
    }
}