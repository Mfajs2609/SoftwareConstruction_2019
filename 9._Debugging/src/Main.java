public class Main {

    static int myNumber = 1234;

    public static void main(String[] args) {
        System.out.println("Let's get started...");
        changeMyNumbers();
        System.out.println("About to finish...");

    }

    public static int changeMyNumbers(){

        myNumber = 2;
        myNumber = 1;

        return myNumber;
    }
}
