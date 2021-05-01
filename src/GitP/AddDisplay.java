package GitP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddDisplay extends JPanel implements Serializable {
    private MainFrame parent;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    ListDisplay list = new ListDisplay();
    Students student = new Students();


    private JButton but1;
    private JButton but2;



    public AddDisplay(MainFrame parent){
        this.parent = parent;

        setLayout(null);
        setSize(500,500);

        lbl1 = new JLabel("Name: ");
        lbl1.setSize(80,20);
        lbl1.setLocation(120,100);
        add(lbl1);

        lbl2 = new JLabel("Surname: ");
        lbl2.setSize(80,20);
        lbl2.setLocation(120,140);
        add(lbl2);

        lbl3 = new JLabel("Age: ");
        lbl3.setSize(80,20);
        lbl3.setLocation(120,180);
        add(lbl3);


        textField1 = new JTextField();
        textField1.setSize(160,20);
        textField1.setLocation(180,100);
        add(textField1);

        textField2 = new JTextField();
        textField2.setSize(160,20);
        textField2.setLocation(180,140);
        add(textField2);


        textField3 = new JTextField();
        textField3.setSize(160,20);
        textField3.setLocation(180,180);
        add(textField3);


        but1 = new JButton("Add");
        but1.setSize(140,30);
        but1.setLocation(100,320);
        add(but1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String surname = textField2.getText();
                int age = Integer.parseInt(textField3.getText());
                student = new Students(null,name, surname,age);
                Client.SendStud(student);

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }

        });

        but2 = new JButton("back");
        but2.setSize(140,30);
        but2.setLocation(280,320);
        add(but2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainDisplay();
            }
        });
    }
    public Students getStudents() {
        return student;
    }
}
