package GitP;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;


public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(1978);
            System.out.println("Ожидание клиента");

            while (true) {


                Socket socket = server.accept();
                System.out.println("клиент подключен");

                ClientHandler ch = new ClientHandler(socket);
                ch.start();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}