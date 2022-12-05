package src.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class author extends JFrame {

    private JPanel contentPane;
    private JTextField searchIDInput;
    private JTextField searchNameInput;
    private JTable listAuthorTable;
    private JTextField manageIDInput;
    private JTextField manageNameInput;
    private JTextField manageAddressInput;
    private JTextField managePhoneInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    author frame = new author();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public author() {
        setResizable(false);
        setTitle("Bookstore Management - Employee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 978, 704);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(10, 10, 101, 22);
        contentPane.add(menuBar);

        JMenu jmenuFile = new JMenu("File");
        menuBar.add(jmenuFile);

        JMenuItem jmenuItemNew = new JMenuItem("New");
        jmenuFile.add(jmenuItemNew);

        JMenuItem jmenuItemOpen = new JMenuItem("Open");
        jmenuFile.add(jmenuItemOpen);

        JSeparator fileMenuSeperator = new JSeparator();
        jmenuFile.add(fileMenuSeperator);

        JMenuItem jmenuItemExit = new JMenuItem("Exit");
        jmenuFile.add(jmenuItemExit);

        JMenu jmenuAbout = new JMenu("About");
        menuBar.add(jmenuAbout);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 30, 926, 2);
        contentPane.add(separator_1);

        JPanel sidebarPane = new JPanel();
        sidebarPane.setBounds(10, 42, 173, 612);
        contentPane.add(sidebarPane);
        sidebarPane.setLayout(null);

        JButton authorManageBtn = new JButton("Author Management");
        authorManageBtn.setBounds(10, 60, 153, 41);
        sidebarPane.add(authorManageBtn);

        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        separator_2.setBounds(193, 30, 2, 624);
        contentPane.add(separator_2);

        JPanel manageAuthorPane = new JPanel();
        manageAuthorPane.setBounds(205, 42, 741, 612);
        contentPane.add(manageAuthorPane);
        manageAuthorPane.setLayout(null);

        JPanel headingControlPane = new JPanel();
        headingControlPane.setBounds(0, 0, 731, 67);
        manageAuthorPane.add(headingControlPane);
        headingControlPane.setLayout(new GridLayout(0, 1, 2, 5));

        JPanel searchControlPane = new JPanel();
        headingControlPane.add(searchControlPane);
        searchControlPane.setLayout(null);

        JLabel searchIdLabel = new JLabel("id");
        searchIdLabel.setBounds(10, 9, 49, 13);
        searchControlPane.add(searchIdLabel);

        searchIDInput = new JTextField();
        searchIDInput.setBounds(69, 6, 96, 19);
        searchControlPane.add(searchIDInput);
        searchIDInput.setColumns(10);

        JLabel searchNameLabel = new JLabel("name");
        searchNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchNameLabel.setBounds(175, 9, 53, 13);
        searchControlPane.add(searchNameLabel);

        searchNameInput = new JTextField();
        searchNameInput.setBounds(238, 6, 96, 19);
        searchControlPane.add(searchNameInput);
        searchNameInput.setColumns(10);

        JButton searchNameBtn = new JButton("Search");
        searchNameBtn.setBounds(613, 5, 87, 21);
        searchControlPane.add(searchNameBtn);

        JPanel sortControlPane = new JPanel();
        headingControlPane.add(sortControlPane);
        sortControlPane.setLayout(null);

        JLabel sortLabel = new JLabel("Sort by");
        sortLabel.setBounds(10, 10, 45, 13);
        sortControlPane.add(sortLabel);

        JComboBox sortCombobox = new JComboBox();
        sortCombobox.addItem("");
        sortCombobox.addItem("ID");
        sortCombobox.addItem("Name");
        sortCombobox.addItem("Address");
        sortCombobox.addItem("Phone");
        sortCombobox.setBounds(65, 6, 105, 21);
        sortControlPane.add(sortCombobox);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(0, 70, 731, 2);
        manageAuthorPane.add(separator_3);

        JScrollPane listAuthorPane = new JScrollPane();
        listAuthorPane.setBounds(0, 93, 731, 205);
        manageAuthorPane.add(listAuthorPane);


        String[] columnNames = {"ID","Name","Address","Phone"};
        String[][] data = {{"TG01","Lebron James","Los Angles Laker","1922302"},{"TG02","Stephen Curry","Golden State Warrior","1922302"},{"TG03","Kevin Durant","Brooklyn Nets","1922302"}};
        listAuthorTable = new JTable(data, columnNames);
        listAuthorPane.setViewportView(listAuthorTable);

        JScrollBar scrollBar = new JScrollBar();
        listAuthorPane.setRowHeaderView(scrollBar);

        JLabel listAuthorLabel = new JLabel("List Authors");
        listAuthorLabel.setBounds(37, 70, 127, 18);
        manageAuthorPane.add(listAuthorLabel);

        JPanel manageControlPane = new JPanel();
        manageControlPane.setBounds(0, 369, 731, 243);
        manageAuthorPane.add(manageControlPane);
        manageControlPane.setLayout(null);

        JLabel manageIDLabel = new JLabel("ID");
        manageIDLabel.setBounds(17, 33, 45, 13);
        manageControlPane.add(manageIDLabel);

        manageIDInput = new JTextField();
        manageIDInput.setBounds(72, 20, 178, 39);
        manageControlPane.add(manageIDInput);
        manageIDInput.setColumns(10);

        JLabel manageNameLabel = new JLabel("Name");
        manageNameLabel.setBounds(17, 82, 45, 13);
        manageControlPane.add(manageNameLabel);

        manageNameInput = new JTextField();
        manageNameInput.setBounds(72, 69, 178, 39);
        manageControlPane.add(manageNameInput);
        manageNameInput.setColumns(10);

        JLabel manageAddressLabel = new JLabel("Address");
        manageAddressLabel.setBounds(308, 33, 69, 13);
        manageControlPane.add(manageAddressLabel);

        manageAddressInput = new JTextField();
        manageAddressInput.setBounds(387, 20, 197, 39);
        manageControlPane.add(manageAddressInput);
        manageAddressInput.setColumns(10);

        JLabel managePhoneLabel = new JLabel("Phone");
        managePhoneLabel.setBounds(308, 82, 69, 13);
        manageControlPane.add(managePhoneLabel);

        managePhoneInput = new JTextField();
        managePhoneInput.setBounds(387, 69, 197, 39);
        manageControlPane.add(managePhoneInput);
        managePhoneInput.setColumns(10);

        JButton manageAddBtn = new JButton("Add");
        manageAddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        manageAddBtn.setBounds(17, 151, 93, 39);
        manageControlPane.add(manageAddBtn);

        JButton manageUpdateBtn = new JButton("Update");
        manageUpdateBtn.setBounds(131, 151, 93, 39);
        manageControlPane.add(manageUpdateBtn);

        JButton manageDelBtn = new JButton("Delete");
        manageDelBtn.setBounds(253, 151, 93, 39);
        manageControlPane.add(manageDelBtn);

        JButton manageEnableBtn = new JButton("Enable");
        manageEnableBtn.setBounds(387, 151, 85, 39);
        manageControlPane.add(manageEnableBtn);

        JButton manageDisableBtn = new JButton("Disable");
        manageDisableBtn.setBounds(513, 151, 85, 39);
        manageControlPane.add(manageDisableBtn);

        JButton manageCancelBtn = new JButton("Cancel");
        manageCancelBtn.setBounds(628, 151, 93, 39);
        manageControlPane.add(manageCancelBtn);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(0, 298, 731, 2);
        manageAuthorPane.add(separator_4);

        JLabel manageLabel = new JLabel("Manage");
        manageLabel.setBounds(37, 335, 45, 13);
        manageAuthorPane.add(manageLabel);
    }
}