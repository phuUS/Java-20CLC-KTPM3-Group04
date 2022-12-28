package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame{

    public LoginForm() {
//        setUndecorated(true);
        setSize(900, 690);
//        setLocationRelativeTo(null);
        userInterface();
    }

    private void userInterface(){
        JPanel main_pan = new JPanel(new GridLayout(1, 2));

        JPanel left_pan = new JPanel(new BorderLayout());
        left_pan.setBackground(Color.DARK_GRAY);

        JLabel cover = new JLabel(new ImageIcon(getClass().getResource("../images/cover.jpeg")));
        cover.setText("Authentication User");
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
        JTextField user = new JTextField();
        user.setPreferredSize(new Dimension(200, 30));
        pan.add(user);

        JLabel _pass = new JLabel("Password");
        _pass.setFont(new Font("Segoe UI", 0, 14));
        _pass.setPreferredSize(new Dimension(200, 20));
        pan.add(_pass);
        JPasswordField pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(200, 30));
        pan.add(pass);

        right_comp.add(pan);

        right_pan.add(right_comp);

        JPanel pan_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pan_btn.setPreferredSize(new Dimension(this.getWidth(), 70));

        JButton login = new JButton("Login");
        login.setPreferredSize(new Dimension(120, 30));
        login.setFont(new Font("Segoe UI", 0, 17));
        login.setContentAreaFilled(false);
        login.setForeground(Color.blue);
        login.setBorder(BorderFactory.createLineBorder(Color.blue, 1, true));
        pan_btn.add(login);
        right_pan.add(pan_btn, "South");

        main_pan.add(right_pan);

        getContentPane().add(main_pan);
    }

    public static void main(String[] args) {
        LoginForm obj = new LoginForm();
        obj.setVisible(true);
    }
}