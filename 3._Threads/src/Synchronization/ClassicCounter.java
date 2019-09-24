package Synchronization;

public class ClassicCounter {
    private int counter = 0;
    //Volatile puts the value in the main memory but won't help us here
    //private volatile int counter = 0;




    public int getCounter() {
        return counter;
    }

    public void decrement() {
        this.counter--;
    }

    public void increment() {
        this.counter++;
    }
}

/*Increment
1. Read local value
2. Increment value
3. Set the local value
 */
