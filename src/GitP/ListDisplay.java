package GitP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDisplay extends JPanel {
    private MainFrame parent;


    private String header[] = {"Name","Surname","Age"};
    private JTable table;
    private JScrollPane scrollPane;

    private JButton but;

    public ListDisplay(){}
    public ListDisplay(MainFrame parent){
        this.parent = parent;


        setSize(500,500);
        setLayout(null);



        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);


        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,400);
        scrollPane.setLocation(100,10);
        add(scrollPane);


        but = new JButton("Go back");
        but.setSize(300,20);
        but.setLocation(100,420);
        add(but);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplay();

            }
        });
    }
    public void generateTable(Students[] students){

        Object Students[][] = new Object[students.length][3];

        for(int i =0;i<students.length;i++){
            Students[i][0] = students[i].getName();
            Students[i][1] = students[i].getSurname();
            Students[i][2] = students[i].getAge();
        }

        DefaultTableModel model = new DefaultTableModel(Students, header);
        this.table.setModel(model);

    }
}
