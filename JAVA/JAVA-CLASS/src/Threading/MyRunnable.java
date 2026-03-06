package Threading;

public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " Thread running");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
