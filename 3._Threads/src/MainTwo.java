import Concurrency.CountingThread;

public class MainTwo  {

    public static void main(String[] args) throws Exception{

        CountingThread countingThread1 = new CountingThread();
        CountingThread countingThread2 = new CountingThread();
        CountingThread countingThread3 = new CountingThread();

        countingThread1.setPriority(Thread.MAX_PRIORITY);
        countingThread2.setPriority(Thread.MIN_PRIORITY);


        countingThread1.setName("One");
        countingThread2.setName("Two");
        countingThread3.setName("Three");


        countingThread1.start();
        countingThread1.join();

        countingThread2.start();
        countingThread2.join();

        countingThread3.start();

        //to research: notify() notifyAll()
    }
}
