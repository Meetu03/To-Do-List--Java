package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task extends JPanel {
    private final JLabel index;
    private final JTextField taskName;
    private final JButton done;
    private boolean checked;

    Task(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(420, 50));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        checked = false;
        index = new JLabel("#");
        index.setPreferredSize(new Dimension(30, 50));
        index.setHorizontalAlignment(JLabel.CENTER);

        taskName = new JTextField("New Task");
        taskName.setBorder(null);
        taskName.setEditable(false);
        taskName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                taskName.setEditable(true);
            }
        });

        done = new JButton("✔");
        done.setPreferredSize(new Dimension(50, 50));
        done.addActionListener(e -> changeState());

        this.add(index, BorderLayout.WEST);
        this.add(taskName, BorderLayout.CENTER);
        this.add(done, BorderLayout.EAST);
    }

    public void changeState(){
        this.setBackground(checked ? Color.WHITE : Color.GREEN);
        taskName.setEditable(false);
        checked = !checked;
    }

    public void changeIndex(int num){
        this.index.setText(num + "");
    }

    public boolean isChecked(){ return checked; }

    public void setDarkMode(boolean isDark) {
        this.setBackground(isDark ? Color.DARK_GRAY : Color.WHITE);
        taskName.setForeground(isDark ? Color.WHITE : Color.BLACK);
    }
}