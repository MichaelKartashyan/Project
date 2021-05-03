package GitP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClientHandler extends Thread implements Serializable {
    private Socket socket;
    private static Connection connection;


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
                if(data.getOperationType().equals("ADD_STUDENT")){
                    if(connect()){
                        addUser(data.getStudent());
                    }
                }else if(data.getOperationType().equals("LIST_STUDENTS")){
                    PackageData response = new PackageData();
                    ArrayList<Students> students = new ArrayList<>();

                    if(connect()){

                        students = getAllStudents();
                        System.out.println("GetAllStudents ok");
                        response.setAllStudents(students);
                        outputStream.writeObject(response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> students = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("select * from students");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                students.add(new Students(id,name,surname,age));
            }
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;

    }
    public static boolean connect(){
        boolean check = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/mproject","root","");
            System.out.println("Connected");
            check = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return check;
    }

    public static  void addUser(Students student){
        try{
            PreparedStatement st = connection.prepareStatement("insert into students(name,surname,age) values(?,?,?)");
            st.setString(1,student.getName());
            st.setString(2,student.getSurname());
            st.setInt(3,student.getAge());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

