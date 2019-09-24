package Deadlock;

public class DeadlockMain {

    public static void main(String[] args) {

        String lockOne = "I'm a lock";
        String lockTwo = "I'm a lock too";


        Thread threadOne = new Thread(){

            public void run() {
                synchronized (lockOne) {
                    System.out.println("Thread 1 is using lock one");
                    try {
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    synchronized (lockTwo) {
                        System.out.println("Thread 2 is using lock Two");
                    }
                }
            }
        };

        Thread threadTwo = new Thread(){

            public void run(){
                synchronized (lockTwo) {
                    System.out.println("Thread 2 is using lock Two");

                    synchronized (lockOne) {
                        System.out.println("Thread 2 is using lock One");
                    }
                }
            }
        };

        threadOne.start();
        threadTwo.start();
    }
}
