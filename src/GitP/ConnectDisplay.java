package GitP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectDisplay extends JPanel {
    MainFrame parent ;
    JTextField ip;
    JTextField port;
    JButton con;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    ConnectDisplay(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);
        ip = new JTextField("Введите ip");
        ip.setBounds(100,100,100,20);
        add(ip);

        port = new JTextField("Введите port");
        port.setBounds(100,150,100,20);
        add(port);

        con = new JButton("Connect");
        con.setBounds(100,200,100,20);
        add(con);
        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect();
                if(Connect()){
                    parent.showMainDisplay();
                }else {
                    ip.setText("Не удалось подключится");
                }

            }
        });

    }

    public Boolean Connect(){
        Boolean succsess = false;
        try {
            Socket socket = new Socket(ip.getText(), Integer.parseInt(port.getText()));
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            succsess = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return succsess;
    }


}
