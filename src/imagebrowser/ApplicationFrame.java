package imagebrowser;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        this.createMenu();
        this.add(createImagePanel());

    }

    private JButton createButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(listeners[index++]);
        return button;
    }

    private void createMenu() {
        JMenu jMenu1;
        JMenuBar jMenuBar1;
        JMenuItem jMenuItem1;

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        openFile();
    }

    private File[] openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        File dir = chooser.getSelectedFile();
        File[] files = dir.listFiles(new ImageFileFilter());
        for (File ff : files) {
            System.out.println("file: " + ff.getName());
        }
        return files;
    }

    public class ImageFileFilter implements FileFilter {

        private final String[] okFileExtensions
                = new String[]{"jpg", "png", "gif"};

        public boolean accept(File file) {
            for (String extension : okFileExtensions) {
                if (file.getName().toLowerCase().endsWith(extension)) {
                    return true;
                }
            }
            return false;
        }
    }

    public JPanel createImagePanel() {
        Imagen Imagen = new Imagen();
        JPanel jPanel1 = new JPanel();
        jPanel1.add(Imagen);
        jPanel1.repaint();
        return jPanel1;
    }
}
