package imagebrowser;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame {
    
    private ActionListener[] listeners;
    private int index = 0;

    public ApplicationFrame(ActionListener[] listeners) throws HeadlessException {
        super("Image Browser");
        this.listeners = listeners;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout());
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createButton("Prev"));
        this.add(createButton("Next"));
    }

    private JButton createButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(listeners[index++]);
        return button;
    }
    
    

}
