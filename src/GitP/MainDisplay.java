package GitP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class MainDisplay extends JPanel implements Serializable {
    MainFrame parent;
    JButton addS;
    JButton list;
    JButton exit;


    PackageData pd = new PackageData();

    public MainDisplay(MainFrame parent) {
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addS = new JButton("Add student ");
        addS.setBounds(200,100,100,30);
        add(addS);
        addS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.ShowAddDisplay();
            }
        });

        list = new JButton("List Student");
        list.setBounds(200,150,100,30);
        add(list);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Client.SendList();
                Client.studentss =  Client.takeStudents();
                parent.ShowListDisplay();
                parent.listDisplay.generateTable(Client.studentss);

            }
        });

        exit = new JButton("Exit");
        exit.setBounds(200,200,100,30);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
