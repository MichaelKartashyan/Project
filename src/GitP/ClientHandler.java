package GitP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;




public class ClientHandler extends Thread implements Serializable {
    private Socket socket;


    public ClientHandler(Socket socket) {
        this.socket = socket;

    }

    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            while ((data = (PackageData) inputStream.readObject()) != null) {
                System.out.println(data);
                PackageData response = new PackageData();
                outputStream.writeObject(response);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

