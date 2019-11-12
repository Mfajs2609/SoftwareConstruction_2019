import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Client {

    public static void main(String[] args) {

        boolean goOnUsername = true;
        boolean goOnChat = true;

        while (goOnChat) {

            try {
                //Starting my socket
                DatagramSocket clientSocket = new DatagramSocket();
                InetAddress IPAdress = InetAddress.getByName("192.168.0.21");

                while (goOnUsername) {


                    byte[] clientDataTransmitter = new byte[1024];
                    byte[] serverDataReceiver = new byte[1024];


                    //Selecting username
                    BufferedReader userSelectedUserName = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Select your username: ");

                    String selectedUserName = "JOIN: " + userSelectedUserName.readLine();

                    clientDataTransmitter = selectedUserName.getBytes();
                    DatagramPacket sendUsername = new DatagramPacket(clientDataTransmitter, clientDataTransmitter.length, IPAdress, 20202);
                    clientSocket.send(sendUsername);


                    //Username Confirmation
                    DatagramPacket userNameConfirm = new DatagramPacket(serverDataReceiver, serverDataReceiver.length);
                    clientSocket.receive(userNameConfirm);

                    serverDataReceiver = userNameConfirm.getData();

                    String messageNameExsists = new String(userNameConfirm.getData());
                    System.out.println(messageNameExsists);

                    if (messageNameExsists.startsWith("FROM SERVER: JOIN OK")) {
                        break;

                    } else {
                        System.out.println("Username occupied...");
                        System.out.println("Try again");
                    }
                }

                try {

                    byte[] clientMessagerTransmitter = new byte[1024];

                    BufferedReader userMessage = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Write your message: ");

                    String message = "MESSAGE: " + userMessage.readLine();

                    clientMessagerTransmitter = message.getBytes();

                    DatagramPacket sendMessage = new DatagramPacket(clientMessagerTransmitter, clientMessagerTransmitter.length, IPAdress, 20202);

                    clientSocket.send(sendMessage);

                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }




            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
/*
        try {

            byte[] clientMessagerTransmitter = new byte[1024];

            BufferedReader userMessage = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write your message: ");

            String message = "MESSAGE: " + userMessage.readLine();

            clientMessagerTransmitter = message.getBytes();

            DatagramPacket sendMessage = new DatagramPacket(clientMessagerTransmitter, clientMessagerTransmitter.length, IPAdress, 20202);

            clientSocket.send(sendMessage);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }
}

