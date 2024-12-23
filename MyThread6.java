public class MyThread6 implements Runnable{
    Thread th;
    public MyThread6(String name){
        th=new Thread(this,name);
        th.start();
    }
    public void run(){
        try{
            for (int i=1;i<=100;i+=2){
                System.out.println(th.getName()+":"+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){
            System.out.println(th.getName()+" interrupted");
        }
        System.out.println(th.getName()+" finished");
    }
}
class UseMyThread6{
    public static void main(String[] args) {
        MyThread4 m1=new MyThread4("child 1");
        try{
            m1.th.join(5000);
            System.out.println("main woked up");
        }catch (InterruptedException ex){
            System.out.println("main interrupted");
        }
        System.out.println("main finished");
    }
}
