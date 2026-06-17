package Threading;

//process that allows concurrent execution of codes
class MyThread extends Thread {
    public void run(){
        for(int i = 1; i <= 2 ; i++){
            System.out.println(i + " Thread running" + " This is a thread");
//            System.out.println(Thread.currentThread()).getname
            try{
                Thread.sleep(500);

            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

