package GitP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Client implements Serializable {
    Students students;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static ArrayList<Students> studentss ;
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

    public static void SendList(){
        try{
            PackageData pd = new PackageData("LIST_STUDENTS");
            outputStream.writeObject(pd);
        }catch (Exception ex){ex.printStackTrace();}
    }

    public static ArrayList<Students> takeStudents(){
        ArrayList<Students> students = new ArrayList<>();
        PackageData data = null;
        try{
            if ((data = (PackageData) inputStream.readObject()) != null) {
                students = data.getStudents();
            }
        }catch (Exception e){e.printStackTrace();}

        return students;
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
