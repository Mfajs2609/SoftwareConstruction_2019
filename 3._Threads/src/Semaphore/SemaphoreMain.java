package Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);


        SemaphoreExample semaphoreOne = new SemaphoreExample((Semaphore) new Object());
        SemaphoreExample semaphoreTwo = new SemaphoreExample((Semaphore) new Object());

        Thread semaphoreThreadOne = new Thread(semaphoreOne);
        Thread semaphoreThreadTwo = new Thread(semaphoreOne);

        semaphoreThreadOne.start();
        semaphoreThreadTwo.start();
    }

}
