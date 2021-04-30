package GitP;

import javax.swing.*;

public class MainFrame extends JFrame {
    ConnectDisplay connectDisplay;
    MainDisplay mainDisplay;
    AddDisplay addDisplay;
    ListDisplay listDisplay;
    public MainFrame(){
        setSize(500,500);
        setLayout(null);
        setTitle("Заявление студента");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connectDisplay = new ConnectDisplay(this);
        connectDisplay.setVisible(true);
        add(connectDisplay);

        mainDisplay = new MainDisplay(this);
        mainDisplay.setVisible(false);
        add(mainDisplay);

        addDisplay = new AddDisplay(this);
        addDisplay.setVisible(false);
        add(addDisplay);

        listDisplay = new ListDisplay(this);
        listDisplay.setVisible(false);
        add(listDisplay);


    }

    public void showMainDisplay(){
        connectDisplay.setVisible(false);
        listDisplay.setVisible(false);
        addDisplay.setVisible(false);
        mainDisplay.setVisible(true);
    }
    public void ShowAddDisplay(){
        connectDisplay.setVisible(false);
        listDisplay.setVisible(false);
        mainDisplay.setVisible(false);
        addDisplay.setVisible(true);
    }
    public void ShowListDisplay(){
        connectDisplay.setVisible(false);
        mainDisplay.setVisible(false);
        addDisplay.setVisible(false);
        listDisplay.setVisible(true);
    }
}
