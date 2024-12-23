package waitAndNotify2;

import javax.swing.plaf.metal.MetalTheme;

public class SharedObj {
    private int n;
    private boolean isConsumed=true;
    synchronized public void set(int i){
        if (isConsumed==false){
            try{
                System.out.println("Producer waiting with "+i);
                wait();
            }catch (InterruptedException ex){
                System.out.println("ShareObj interrupted");
            }
        }
        n=i;
        isConsumed=false;
        notify();
    }
    synchronized public int get(){
        if (isConsumed==true){
            try{
                System.out.println("Consumer waiting after consuming "+n);
                wait();
            }catch (InterruptedException ex){

            }
        }
        isConsumed=true;
        notify();
        return n;
    }
}
class Producer extends Thread{
    private SharedObj s;
    public Producer(SharedObj obj){
        s=obj;
        start();
    }
    public void run(){
        try{
            for (int i=1;i<=10;i++){
                s.set(i);
                System.out.println("Produced: "+i);
                Thread.sleep((int)(Math.random()*3000));
            }
        }catch (InterruptedException ex){
            System.out.println("Producer interrupted");
        }
    }
}

class Consumer extends Thread{
    private SharedObj s;
    public Consumer(SharedObj obj){
        s=obj;
        start();
    }
    public void run(){
        try{
            int sum=0;
            for (int i=1;i<=10;i++){
                int x=s.get();
                System.out.println("Consumed: "+x);
                sum=sum+x;
                Thread.sleep((int)(Math.random()*3000));
            }
            System.out.println("Sum is "+sum);
        }catch (InterruptedException ex){
            System.out.println("Consumer interrupted");
        }
    }
}

class ProdConsProb{
    public static void main(String[] args) {
        SharedObj obj=new SharedObj();
        Producer p=new Producer(obj);
        Consumer c=new Consumer(obj);
        try{
            p.join();
            c.join();
        }catch (InterruptedException ex){
            System.out.println("main interrupted");
        }
    }
}