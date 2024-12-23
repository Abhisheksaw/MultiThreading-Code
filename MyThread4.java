public class MyThread4 implements Runnable{
    Thread th;
    public MyThread4(String name){
        th=new Thread(this,name);
        th.start();
    }
    public void run(){
        try{
            for (int i=1;i<=10;i+=2){
                System.out.println(th.getName()+":"+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){
            System.out.println(th.getName()+" interrupted");
        }
        System.out.println(th.getName()+" finished");
    }
}
class UseMyThread4{
    public static void main(String[] args) {
        MyThread4 m1=new MyThread4("child 1");
        MyThread4 m2=new MyThread4("child 2");
        MyThread4 m3=new MyThread4("child 3");

        try{
            for (int i=2;i<=10;i+=2){
                System.out.println("main: "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex){
            System.out.println("main interrupted");
        }
        System.out.println("main finished");
    }
}
