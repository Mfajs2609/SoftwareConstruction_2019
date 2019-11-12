import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class UDP_Server {

    public static void main(String[] args) {

        ArrayList<InetAddress> ipArray = new ArrayList<>();
        ArrayList<Integer> portArray = new ArrayList<>();
        ArrayList<String> participants = new ArrayList<>();
        ArrayList<String> exsistingPartisipants = new ArrayList<>();

        boolean goOn = true;

            try {

                DatagramSocket serverSocket = new DatagramSocket(20202);

                byte[] clientDataReceiver = new byte[1024];
                byte[] serverDataTransmitter = new byte[1024];
                System.out.println("Starting the server...");

                //Create a DatagramPacket to receive the Username data.
                DatagramPacket inFromClientUsername = new DatagramPacket(clientDataReceiver, clientDataReceiver.length);

                //Receieve the data in byte buffer.
                serverSocket.receive(inFromClientUsername);
                ipArray.add(inFromClientUsername.getAddress());
                portArray.add(inFromClientUsername.getPort());

                String selectedUsername = new String(inFromClientUsername.getData());




                DatagramPacket messageReceiver = new DatagramPacket(clientDataReceiver, clientDataReceiver.length);

                serverSocket.receive(messageReceiver);
                ipArray.add(messageReceiver.getAddress());
                portArray.add(messageReceiver.getPort());

                String message = new String(messageReceiver.getData());

                boolean exsistingUsername = exsistingPartisipants.contains(selectedUsername);

                while (goOn) {

                    if (selectedUsername.startsWith("JOIN: ") && !exsistingUsername) {

                        String message1 = "FROM SERVER: JOIN OK";

                        participants.add(selectedUsername.substring(6));
                        exsistingPartisipants.add(selectedUsername.substring(6));

                        System.out.println("NEW CLIENT: [" + selectedUsername.substring(6) + "]");
                        System.out.println("Participants: " + participants.size());

                        System.out.println(ipArray.toString() + portArray + participants);

                        serverDataTransmitter = message1.getBytes();
                        DatagramPacket sendUserNameIsAcceptedPacket = new DatagramPacket(serverDataTransmitter, serverDataTransmitter.length, (inFromClientUsername.getAddress()), (inFromClientUsername.getPort()));
                        serverSocket.send(sendUserNameIsAcceptedPacket);
                        clientDataReceiver = new byte[1024];

                    } else if (selectedUsername.startsWith("JOIN: ") && exsistingUsername) {

                        String message2 = "FROM SERVER: JOIN ERROR... username occupied";

                        serverDataTransmitter = message2.getBytes();
                        DatagramPacket sendUserNameIsOccupiedPacket = new DatagramPacket(serverDataTransmitter, serverDataTransmitter.length, (inFromClientUsername.getAddress()), (inFromClientUsername.getPort()));
                        serverSocket.send(sendUserNameIsOccupiedPacket);
                        clientDataReceiver = new byte[1024];

                    } else if (message.startsWith("MESSAGE: ")) {

                        System.out.println("FROM USER: " + "[" + selectedUsername.substring(6) + "] " + "MESSAGE: " + "[" + selectedUsername.substring(9) + "]");
                        clientDataReceiver = new byte[1024];

                    } else if (message.contains("QUIT")) {

                        System.out.println("[" + selectedUsername.substring(6) + "] Left");
                        participants.remove(selectedUsername.substring(6));

                        System.out.println("Participant: " + participants.size());
                        clientDataReceiver = new byte[1024];
                    }

                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

