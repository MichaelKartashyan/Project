package GitP;

import javax.swing.*;

public class MainFrame extends JFrame {

    MainDisplay mainDisplay;
    AddDisplay addDisplay;
    ListDisplay listDisplay;
    public MainFrame(){
        setSize(500,500);
        setLayout(null);
        setTitle("Заявление студента");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        mainDisplay = new MainDisplay(this);
        mainDisplay.setVisible(true);
        add(mainDisplay);

        addDisplay = new AddDisplay(this);
        addDisplay.setVisible(false);
        add(addDisplay);

        listDisplay = new ListDisplay(this);
        listDisplay.setVisible(false);
        add(listDisplay);


    }

    public void showMainDisplay(){
        listDisplay.setVisible(false);
        addDisplay.setVisible(false);
        mainDisplay.setVisible(true);
    }
    public void ShowAddDisplay(){
        listDisplay.setVisible(false);
        mainDisplay.setVisible(false);
        addDisplay.setVisible(true);
    }
    public void ShowListDisplay(){
        mainDisplay.setVisible(false);
        addDisplay.setVisible(false);
        listDisplay.setVisible(true);
    }
}
