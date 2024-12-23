package Bank;

public class Bank extends Thread{
    int bal=5000;
    int withdraw;
    public Bank(int withdraw){
        this.withdraw=withdraw;
    }
    synchronized public void run(){
        String name=Thread.currentThread().getName();
        if(withdraw<=bal){
            System.out.println(name+" withdraw Money");
            bal=bal-withdraw;
        }else {
            System.out.println("Insufficient Balance");
        }
    }
}
class Customer{
    public static void main(String[] args) {
        Bank obj=new Bank(5000);      // obj has one lock

        Thread th1=new Thread(obj);
        Thread th2=new Thread(obj);
        th1.setName("Ram");
        th2.setName("Sita");

        th1.start();
        th2.start();
    }
}