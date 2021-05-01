package GitP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    Students students;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static void main(String[] args) {

        if(Connect()){
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        }else {
            System.out.println("Не удалось подключиться");
        }
    }
    public static void SendStud(Students students){
        PackageData pd = new PackageData();
        pd.setStudents(students);

        try{
            System.out.println(students.toString());
            pd = new PackageData("ADD_STUDENT",students);
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }

    public static Boolean Connect(){
        Boolean succsess = false;
        try {
            Socket socket = new Socket("127.0.0.1",1978);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            succsess = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return succsess;
    }
}
