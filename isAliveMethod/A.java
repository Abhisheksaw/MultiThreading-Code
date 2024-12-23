package isAliveMethod;

public class A extends Thread{
    public void run(){
        String name=Thread.currentThread().getName();
        for(int i=1;i<=3;i++){
            System.out.println(name);
        }
    }
}
class B{
    public static void main(String[] args) {
        A th1=new A();
        A th2=new A();

        th1.setName("Thread 1");
        th2.setName("Thread 2");

        System.out.println(th1.isAlive());
        th1.start();
        System.out.println(th1.isAlive());
        th2.start();
    }
}