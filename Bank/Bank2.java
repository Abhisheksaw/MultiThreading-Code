package Bank;

public class Bank2 extends Thread{
    static int bal=5000;
    static int withdraw;
    public Bank2(int withdraw){
        this.withdraw=withdraw;
    }
    public static synchronized void moneyWithdraw(){
        String name=Thread.currentThread().getName();
        if(withdraw<=bal){
            System.out.println(name+" withdraw Money");
            bal=bal-withdraw;
        }else {
            System.out.println("Insufficient Balance");
        }
    }
    public void run(){
        moneyWithdraw();
    }
}
class Customer2{
    public static void main(String[] args) {
        Bank2 obj=new Bank2(5000);      // obj has one lock

        Thread th1=new Thread(obj);
        Thread th2=new Thread(obj);
        th1.setName("Ram");
        th2.setName("Sita");

        Bank2 obj2=new Bank2(5000);      // obj has one lock

        Thread th3=new Thread(obj2);
        Thread th4=new Thread(obj2);
        th3.setName("Sohan");
        th4.setName("Mohani");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}