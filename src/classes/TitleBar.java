package classes;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {
    TitleBar(){
        this.setPreferredSize(new Dimension(450, 60));
        JLabel title = new JLabel("To-Do List");
        title.setFont(new Font("Sans-serif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);
    }
}
