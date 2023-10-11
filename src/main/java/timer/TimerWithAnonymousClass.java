package timer;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;

// Before Lambda Expressions

public class TimerWithAnonymousClass {
    public static void main(String[] args) {
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                Toolkit.getDefaultToolkit().beep();
            }
        });

        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);


        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                Toolkit.getDefaultToolkit().beep();
            }
        };
    }
}
