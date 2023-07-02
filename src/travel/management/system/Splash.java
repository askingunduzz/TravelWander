package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame  {
    Thread thread;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dest9.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1900, 1200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i1);
        add(image);

        setVisible(true);

        thread.start();
    }


    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;
        for (int i = 1; i <= 700; x += 7, i += 10) {
            frame.setLocation(650 - (x + i) / 2, 350 - (i) / 2);
            frame.setSize(i + x, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}