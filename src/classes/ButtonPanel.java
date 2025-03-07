package classes;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private final JButton addTask;
    private final JButton clear;
    private final JToggleButton darkModeToggle;

    ButtonPanel(){
        this.setPreferredSize(new Dimension(450, 60));
        this.setBackground(Color.LIGHT_GRAY);

        addTask = new JButton("Add Task");
        clear = new JButton("Clear Completed Tasks");
        darkModeToggle = new JToggleButton("Dark Mode");

        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        clear.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        darkModeToggle.setFont(new Font("Sans-serif", Font.PLAIN, 16));

        this.add(addTask);
        this.add(Box.createHorizontalStrut(15));
        this.add(clear);
        this.add(Box.createHorizontalStrut(15));
        this.add(darkModeToggle);
    }

    public JButton getAddTask(){ return addTask; }
    public JButton getClear(){ return clear; }
    public JToggleButton getDarkModeToggle(){ return darkModeToggle; }
}
