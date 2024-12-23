package ThreadSchedular;

public class A extends Thread{
    public void run(){
        String n=Thread.currentThread().getName();
        for (int i=1;i<=3;i++){
            System.out.println(n);
        }
    }
}
class B{
    public static void main(String[] args) {
        A th1=new A();
        A th2=new A();
        A th3=new A();

        th1.setName("Abhishek");
        th2.setName("Abhijeet");
        th3.setName("Anisha");

        th1.start();
        th2.start();
        th3.start();

        String n=Thread.currentThread().getName();
        for (int i=1;i<=3;i++){
            System.out.println(n);
        }
    }
}