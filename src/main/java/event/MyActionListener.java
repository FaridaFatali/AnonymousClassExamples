package event;

import javax.swing.*;
import java.awt.event.*;

public class MyActionListener implements ActionListener {
    private MyApplication application;

    public MyActionListener(MyApplication application) {
        this.application = application;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        String buttonLabel = button.getText();
        application.buttonClicked(buttonLabel);
    }
}
