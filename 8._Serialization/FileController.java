import java.io.*;

public class FileController {

    public static void saveToFile(Chair chair) {
        try {

            FileOutputStream fileOutput = new FileOutputStream(new File("chair.txt"));
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(chair);

            fileOutput.close();
            objectOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("chair.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Chair chair = (Chair) objectInputStream.readObject();

            System.out.println(chair);
            System.out.println(chair.size);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}