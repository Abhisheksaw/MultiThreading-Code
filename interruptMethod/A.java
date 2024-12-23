package interruptMethod;

public class A extends Thread{
    public void run(){
        String name=Thread.currentThread().getName();
        try {
            for (int i=1;i<=3;i++) {
                System.out.println(name);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("t1 thread terminated...");
        }
    }
}
class B{
    public static void main(String[] args) {
        A th1=new A();
        A th2=new A();

        th1.setName("Thread 1");
        th2.setName("Thread 2");

        th1.start();
        th2.start();

        th1.interrupt();
    }
}