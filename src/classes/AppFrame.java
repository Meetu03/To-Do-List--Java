package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private final List list;
    private final JButton addTask;
    private final JButton clear;
    private final JToggleButton darkModeToggle;

    AppFrame(){
        this.setSize(450, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        TitleBar title = new TitleBar();
        list = new List();
        ButtonPanel btnPanel = new ButtonPanel();

        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();
        darkModeToggle = btnPanel.getDarkModeToggle();

        addListeners();
        this.setVisible(true);
    }

    private void addListeners(){
        addTask.addActionListener(e -> {
            Task task = new Task();
            list.add(task);
            list.updatedNumbers();
        });

        clear.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Clear all completed tasks?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                list.removeCompletedTasks();
            }
        });

        darkModeToggle.addActionListener(e -> toggleDarkMode(darkModeToggle.isSelected()));
    }

    private void toggleDarkMode(boolean isDark) {
        Color bgColor = isDark ? Color.DARK_GRAY : Color.WHITE;
        Color fgColor = isDark ? Color.WHITE : Color.BLACK;
        this.getContentPane().setBackground(bgColor);
        list.setBackground(bgColor);
        for (Component c : list.getComponents()) {
            if (c instanceof Task) {
                ((Task) c).setDarkMode(isDark);
            }
        }
    }
}