import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        FileController.saveToFile(new Chair(343.02, false));

        FileController.readFromFile();
    }
}
