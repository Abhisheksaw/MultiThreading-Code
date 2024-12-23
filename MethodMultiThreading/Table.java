package MethodMultiThreading;

public class Table {
    synchronized public void tablePrint(int n){
        for (int i=1;i<=10;i++){
            System.out.println(n*i);
        }
    }
}
class thread1 extends Thread{
    Table tab;
    public thread1(Table tab){
        this.tab=tab;
    }
    public void run(){
        tab.tablePrint(5);
    }
}
class thread2 extends Thread{
    Table tab;
    public thread2(Table tab){
        this.tab=tab;
    }
    public void run(){
        tab.tablePrint(7);
    }
}
class UseTable{
    public static void main(String[] args) {
        Table obj=new Table();

        thread1 th1=new thread1(obj);
        thread2 th2=new thread2(obj);
        th1.start();
        th2.start();
    }
}