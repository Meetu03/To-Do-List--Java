package classes;

import javax.swing.*;
import java.awt.*;

public class List extends JPanel {
    List(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
    }

    public void updatedNumbers(){
        Component[] tasks = this.getComponents();
        for (int i = 0; i < tasks.length; i++){
            if (tasks[i] instanceof Task){
                ((Task) tasks[i]).changeIndex(i + 1);
            }
        }
    }

    public void removeCompletedTasks(){
        for (Component task : this.getComponents()){
            if (task instanceof Task && ((Task) task).isChecked()){
                this.remove(task);
            }
        }
        this.revalidate();
        this.repaint();
    }
}
