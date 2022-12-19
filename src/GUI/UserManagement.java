package GUI;

import BUS.UserBUS;
import POJO.UserPOJO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserManagement extends JFrame implements ActionListener {
    JPanel menuPane;
    JButton backButton;

    final int SIDEBARPANE_WIDTH = 150;
    JPanel sidebarPane;
    JButton allUsersButton;

    JPanel contentPane;
    JLabel contentLable;
    JTable userTable;
    JScrollPane userTableScroll;

    public UserManagement() {
        setTitle("Admin - Book Management");
        setSize(1000, 700);
        setBackground(Color.BLUE);
        setLayout(new BorderLayout(0,0));

        menuPane = new JPanel();
        menuPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPane.setBackground(Color.GRAY);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        menuPane.add(backButton);

        sidebarPane = new JPanel();
        sidebarPane.setLayout(new BoxLayout(sidebarPane, BoxLayout.Y_AXIS));
        sidebarPane.setPreferredSize(new Dimension(SIDEBARPANE_WIDTH, 0));
        sidebarPane.setBorder(new LineBorder(Color.BLACK, 1));
        sidebarPane.setBackground(Color.LIGHT_GRAY);

        allUsersButton = new JButton("All Users");
        allUsersButton.setMaximumSize(new Dimension(SIDEBARPANE_WIDTH, 30));
        allUsersButton.setFocusable(false);
        allUsersButton.addActionListener(this);

        sidebarPane.add(allUsersButton);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentLable = new JLabel();
        contentLable.setText("All of users list");

        userTable = null;
        userTableScroll = new JScrollPane(userTable);

        contentPane.add(contentLable);
        contentPane.add(userTableScroll);

        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getAllUsersTable() {
        String col[]={"ID","USERNAME","PASSWORD"};
        ArrayList<UserPOJO> allUsers = UserBUS.getAll();

        JTable result = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < allUsers.size(); i++){
            String id = allUsers.get(i).getId();
            String username = allUsers.get(i).getUsername();
            String password = allUsers.get(i).getPassword();
            Object[] data = {id, username, password};
            tableModel.addRow(data);
        }
        result.setModel(tableModel);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allUsersButton){
            if (userTable != null) {
                contentPane.remove(userTable);
            }
            userTable = getAllUsersTable();
            userTableScroll.setViewportView(userTable);
            contentPane.add(userTableScroll);
            contentLable.setText("Here are all the users");
            revalidate();
        }
    }
}
