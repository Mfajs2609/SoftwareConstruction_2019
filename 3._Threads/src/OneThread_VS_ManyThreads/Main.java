package OneThread_VS_ManyThreads;

public class Main
{
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++){

            System.out.println(i);
        }

        long endTime= System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Time in nanoseconds : " + timeElapsed);

        System.out.println("Time in milliseconds : " + timeElapsed /1000000);
    }


}
