import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class UDP_Server {

    public static void main(String[] args) {

        boolean goOn = true;

        //Arraylist for Ip and Port
        ArrayList<InetAddress> ipArray = new ArrayList<>();
        ArrayList<Integer> portArray = new ArrayList<>();

        try {

            //Starting server on port.
            DatagramSocket serverSocket = new DatagramSocket(20202);

            //Byte buffers to hold messages to and from server.
            byte[] clientDataReceiver = new byte[1024];
            byte[] serverDataTransmitter = new byte[1024];
            System.out.println("Starting the server...");

            //Create a DatagramPacket to receive the Username data.
            DatagramPacket userNameReceiver = new DatagramPacket(clientDataReceiver, clientDataReceiver.length);

            //Receieve the data in byte buffer. Data, ip and port for later uses.
            serverSocket.receive(userNameReceiver);
            ipArray.add(userNameReceiver.getAddress());
            portArray.add(userNameReceiver.getPort());

            //Making a String object with the data from datagrampacket.
            String selectedUsername = new String(userNameReceiver.getData());

            //Clearing the buffer.
            clientDataReceiver = new byte[1024];

            //String Arraylist for all exsisting participants.
            ArrayList<String> exsistingPartisipants = new ArrayList<>();
            exsistingPartisipants.add("Test");

            //String Arraylist for all active participants.
            ArrayList<String> participants = new ArrayList<>();

            //Useing a boolean to see if a new participants username is already taken.
            boolean userNameExsists = exsistingPartisipants.contains(selectedUsername.substring(5).trim());

                //If the message from client starts with JOIN: and is not taken...
                if (selectedUsername.startsWith("JOIN: ") && !userNameExsists) {
                    System.out.println(selectedUsername);

                    //Declaring what message i want to send to client.
                    String message1 = "FROM SERVER: JOIN OK";

                    //Adding to arraylist.
                    participants.add(selectedUsername.substring(6));
                    exsistingPartisipants.add(selectedUsername.substring(6));

                    System.out.println("NEW CLIENT: [" +selectedUsername.substring(6) + "]");
                    System.out.println("Participants: " + participants.size());

                    //Printing the Ip address, port and active participants.
                    System.out.println(ipArray.toString() + portArray + participants);

                    //Putting message1 into the buffer serverDataTransmitter of bytes.
                    serverDataTransmitter = message1.getBytes();

                    //Creating a datagrampacket with the data, ip and port number.
                    DatagramPacket sendUserNameIsAcceptedPacket = new DatagramPacket(serverDataTransmitter, serverDataTransmitter.length, (userNameReceiver.getAddress()), (userNameReceiver.getPort()));

                    //Send the UDP packet to client.
                    serverSocket.send(sendUserNameIsAcceptedPacket);

                    //If username exsists.
                } else if (selectedUsername.startsWith("JOIN: ") && userNameExsists) {

                    String message2 = "FROM SERVER: JOIN ERROR... username occupied";

                    serverDataTransmitter = message2.getBytes();
                    DatagramPacket sendUserNameIsOccupiedPacket = new DatagramPacket(serverDataTransmitter, serverDataTransmitter.length, (userNameReceiver.getAddress()), (userNameReceiver.getPort()));
                    serverSocket.send(sendUserNameIsOccupiedPacket);
                }

            while (goOn) {
                //Creating a DatagramPacket to receive the message data.
                DatagramPacket messageReceiver = new DatagramPacket(clientDataReceiver, clientDataReceiver.length);

                serverSocket.receive(messageReceiver);
                ipArray.add(messageReceiver.getAddress());
                portArray.add(messageReceiver.getPort());

                String message = new String(messageReceiver.getData());

                //If statements to see if its a message or quit.
                if (message.startsWith("MESSAGE: ")) {
                    System.out.println("FROM USER: " + "[" + selectedUsername.substring(6) + "] " + "MESSAGE: " + "[" + message.substring(9) + "]");
                    clientDataReceiver = new byte[1024];
                }

                if (message.contains("QUIT")) {
                    System.out.println("[" + selectedUsername.substring(6) + "] Left");
                    participants.remove(selectedUsername.substring(6));

                    System.out.println("Participant: " + participants.size());
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}



