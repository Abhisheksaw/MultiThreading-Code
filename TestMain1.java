public class TestMain1 {
    public static void main(String[] args) {
        Thread th=Thread.currentThread();
        System.out.println("Thread Details"+th);
        th.setName("Abhishek");
        System.out.println("After name change "+th);
        try{
            for (int i=1;i<=5;i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex){
            System.out.println(th.getName()+" interrupted");
        }
        System.out.println(th.getName()+" finished");
    }
}