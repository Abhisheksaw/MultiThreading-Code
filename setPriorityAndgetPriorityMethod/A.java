package setPriorityAndgetPriorityMethod;

public class A extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }
}
class B{
    public static void main(String[] args) {
        A th1=new A();
        A th2=new A();
        A th3=new A();

        th1.setName("Thread 1");
        th2.setName("Thread 2");
        th3.setName("Thread 3");

        th1.setPriority(Thread.NORM_PRIORITY+1);
        th2.setPriority(Thread.MIN_PRIORITY+1);
        th3.setPriority(Thread.MIN_PRIORITY+4);

        th1.start();
        th2.start();
        th3.start();
    }
}