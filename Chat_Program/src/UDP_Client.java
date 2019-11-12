import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Client extends Thread{

    public static void main(String[] args) {

        boolean goOn = false;

        try {
            //Starting my socket.
            DatagramSocket clientSocket = new DatagramSocket();

            //Byte buffers to hold messages to and from client.
            byte[] clientDataTransmitter = new byte[1024];
            byte[] serverDataReceiver = new byte[1024];

            //Ip for server location.
            /*Ip her -->*/ InetAddress IPAdress = InetAddress.getByName("10.150.12.190");

            //Selecting username with input stream.
            BufferedReader userSelectedUserName = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select your username: ");

            //Making a String object with the data from the input stream, the String contains
            //"JOIN: " so the server knows that its a JOIN message.
            String selectedUserName = "JOIN: " + userSelectedUserName.readLine();

            //Putting selectedUserName into the buffer clientDataTransmitter of bytes.
            clientDataTransmitter = selectedUserName.getBytes();

            //Creating a datagrampacket with the data, ip and port number.
            DatagramPacket sendUsername = new DatagramPacket(clientDataTransmitter, clientDataTransmitter.length, IPAdress, 20202);

            //Send the UDP packet to server.
            clientSocket.send(sendUsername);


            //Username Confirmation.
            DatagramPacket userNameConfirm = new DatagramPacket(serverDataReceiver, serverDataReceiver.length);

            //Receiveing a packet from the server.
            clientSocket.receive(userNameConfirm);

            //Unpackes the reply from the DatagramPacket.
            String messageNameExsists = new String(userNameConfirm.getData());
            System.out.println(messageNameExsists);

            //If statement to see if the username is accepted.
            if (messageNameExsists.startsWith("JOIN OK")) {
                goOn = true;

            }else{
                System.out.println("Try again");
            }

            //While loop to start and keep the chat going after confirmation from server.
            while (goOn) {

                //MESSAGE
                BufferedReader userMessage = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Write your message: ");

                String message = "MESSAGE: " + userMessage.readLine();

                clientDataTransmitter = message.getBytes();
                DatagramPacket sendMessage = new DatagramPacket(clientDataTransmitter, clientDataTransmitter.length, IPAdress, 20202);
                clientSocket.send(sendMessage);


                if (message.substring(9).contains("QUIT")) {

                    String quitMessage = "QUIT" + userMessage.readLine().trim();

                    clientDataTransmitter = quitMessage.getBytes();
                    DatagramPacket sendMessage1 = new DatagramPacket(clientDataTransmitter, clientDataTransmitter.length, IPAdress, 20202);
                    clientSocket.send(sendMessage1);
                    goOn = false;
                }

                //Se ReadMe
                Thread getMessage = new Thread(new ClientReceiver(clientSocket));

                //Starts a new thread.
                getMessage.start();
            }
            clientSocket.close();

        } catch(SocketException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

