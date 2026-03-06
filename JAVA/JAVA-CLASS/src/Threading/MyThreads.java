package Threading;

public class MyThreads {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        t1.start();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        try{
            t1.join();
        }catch (InterruptedException w){
            System.out.println(w);
        }
        t2.start();
    }
}
