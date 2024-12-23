class MyThread extends Thread{
    public MyThread(String name){
        super(name);
        System.out.println("Thread Details: "+this);
    }
    public void run(){
        try{
            for (int i=1;i<=10;i+=2){
                System.out.println(super.getName()+":"+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex){
            System.out.println(super.getName()+" interrupted");
        }
        System.out.println(super.getName()+" finished");
    }
}
class UseMyThread{
    public static void main(String[] args) {
        MyThread m1=new MyThread("child");
        m1.start();
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
