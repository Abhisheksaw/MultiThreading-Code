package BlockMultiThreading;

public class msg {
    public void msgPrint(String name){
        // 100 line of codes             //Home

        synchronized (this){
            for (int i=1;i<=3;i++){
                System.out.println("How are you "+name);
            }
        }

        // 100 line of codes            //School
    }
}
class OurThread extends Thread{
    msg m;
    String name;
    public OurThread(msg m,String name){
        this.m=m;
        this.name=name;
    }
    public void run(){
        m.msgPrint(name);
    }
}
class Usemsg{
    public static void main(String[] args) {
        msg obj=new msg();

        OurThread th1=new OurThread(obj, "Abhishek");
        OurThread th2=new OurThread(obj, "Abhijeet");
        th1.start();
        th2.start();
    }
}