import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ClientReceiver implements Runnable{

    DatagramSocket ClientSocket;

    //Constructor
    public ClientReceiver(DatagramSocket socket) {
        this.ClientSocket = socket;
    }

    public void run() {

        try {

            ////Byte buffer to hold messages from server.
            byte[] receiveData = new byte[1024];

            //Creating a DatagramPacket to receive the data.
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            ////Receieve the data in byte buffer.
            ClientSocket.receive(receivePacket);

            //Unpack the reply from the DatagramPacket
            String serverReply =  new String(receivePacket.getData(), 0, receivePacket.getLength());

            //Print reply
            System.out.println(serverReply);

            //Stop Thread
            Thread.yield();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}