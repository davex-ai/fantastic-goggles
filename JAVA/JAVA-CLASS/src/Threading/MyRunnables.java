package Threading;

public class MyRunnables {
    public static void main(String[] args) {
        MyRunnable t2 = new MyRunnable();
        Thread t1 = new Thread (t2);
        t1.start();
    }
}
