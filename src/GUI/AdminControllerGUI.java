package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminControllerGUI extends JFrame implements ActionListener{
    private JButton logoutButton;
    static JFrame frame;
    private JPanel menuPane;

    private JButton editInfoButton;
    private JPanel contentPane;
    public AdminControllerGUI() {
        setSize(900, 600);
        userInterface();
    }

    private void userInterface(){

         menuPane = new JPanel();
        menuPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPane.setBackground(Color.GRAY);

        logoutButton = new JButton("Logout");
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        menuPane.add(logoutButton);

        editInfoButton = new JButton("Information");
        editInfoButton.setFocusable(false);
        editInfoButton.addActionListener(this);
        menuPane.add(editInfoButton);

        JPanel main_pan = new JPanel(new GridLayout(1, 2));

        JPanel left_pan = new JPanel(new BorderLayout());
        left_pan.setBackground(Color.DARK_GRAY);

        JLabel cover = new JLabel(new ImageIcon(getClass().getResource("../images/admin-img.png")));

        cover.setHorizontalTextPosition(JLabel.CENTER);
        cover.setVerticalTextPosition(JLabel.BOTTOM);
        cover.setForeground(Color.white);
        cover.setFont(new Font("Segoe UI", 0, 15));
        left_pan.add(cover);

        main_pan.add(left_pan);

        JPanel right_pan = new JPanel(new BorderLayout());
        right_pan.setBackground(Color.white);

        JPanel right_comp = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Sign In");
        title.setPreferredSize(new Dimension(this.getWidth(), 70));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Segoe UI", 0, 30));
        right_comp.add(title, "North");

        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel _user = new JLabel("Username");
        _user.setFont(new Font("Segoe UI", 0, 14));
        _user.setPreferredSize(new Dimension(200, 20));
        pan.add(_user);
        

        main_pan.add(right_pan);

        getContentPane().add(main_pan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton ){
            ///
        }
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Admin - Book Management");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setLayout(new BorderLayout(0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        AdminControllerGUI newContentPane = new AdminControllerGUI();
        // newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

     public static void main(String[] args) {
       //Schedule a job for the event-dispatching thread:
       //creating and showing this application's GUI.
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               createAndShowGUI();
           }
       });
   }
}
