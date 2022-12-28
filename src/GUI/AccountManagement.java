package GUI;

import BUS.AccountBUS;
import BUS.UserBUS;
import POJO.AccountPOJO;
import POJO.UserPOJO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountManagement extends JPanel implements ActionListener {
    JPanel menuPane;
    JButton backButton;

    final int SIDEBARPANE_WIDTH = 180;
    JPanel sidebarPane;
    JButton allAccountsButton;
    JButton allUserButton;

    JButton addNewAccount;

    JPanel contentPane;
    JLabel contentLabel;
    JScrollPane scrollPane;
    JPanel form;

    JPanel menu;

    private boolean DEBUG = false;
    private JTable table;
    private JTextField filterText;
    private JTextField statusText;

    TableRowSorter<AccountManagement.AllAccounts> sorter1;
    AccountManagement.AllAccounts model1;

    TableRowSorter<AccountManagement.AllUsers> sorter2;
    AccountManagement.AllUsers model2;


    public AccountManagement() {
        super();
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

        allAccountsButton = new JButton("All accounts");
        allAccountsButton.setMaximumSize(new Dimension(SIDEBARPANE_WIDTH, 30));
        allAccountsButton.setFocusable(false);
        allAccountsButton.addActionListener(this);

        allUserButton = new JButton("All users information");
        allUserButton.setMaximumSize(new Dimension(SIDEBARPANE_WIDTH, 30));
        allUserButton.setFocusable(false);
        allUserButton.addActionListener(this);

        addNewAccount = new JButton("Add a new account");
        addNewAccount.setMaximumSize(new Dimension(SIDEBARPANE_WIDTH, 30));
        addNewAccount.setFocusable(false);
        addNewAccount.addActionListener(this);

        sidebarPane.add(allAccountsButton);
        sidebarPane.add(allUserButton);
        sidebarPane.add(addNewAccount);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentLabel = new JLabel();
        contentLabel.setText("WELCOME TO THE ADMIN PAGE!");
        contentPane.add(contentLabel);


        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == allAccountsButton){
            if(contentPane != null){
                contentPane.removeAll();
            }
            this.getTableAllAccountsButton();

        } else if (e.getSource() == allUserButton){
            if(contentPane != null){
                contentPane.removeAll();
            }
            this.getTableAllUsersButton();
        }
    }

    public void getTableAllAccountsButton(){
        model1 = new AccountManagement.AllAccounts();
        sorter1 = new TableRowSorter<AccountManagement.AllAccounts>(model1);
        table = new JTable(model1);
        table.setRowSorter(sorter1);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            statusText.setText("");
                        } else {
                            int modelRow =
                                    table.convertRowIndexToModel(viewRow);
                            statusText.setText(
                                    String.format("Selected Row in view: %d. " +
                                                    "Selected Row in model: %d.",
                                            viewRow, modelRow));
                        }
                    }
                }
        );
        scrollPane = new JScrollPane(table);
        form = new JPanel(new SpringLayout());
        menu = new JPanel(new SpringLayout());
        JButton disableButton = new JButton("Disable");
        menu.add(disableButton);
        JButton enableButton = new JButton("Enable");
        menu.add(enableButton);
        JButton resetPassButton = new JButton("Reset password");
        menu.add(resetPassButton);
        menu.setBackground(Color.red);
        SpringUtilities.makeCompactGrid(menu, 1, 3, 6, 6, 6, 6);
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField();
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter1();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter1();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter1();
                    }
                });
        l1.setLabelFor(filterText);
        form.add(filterText);
        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
        form.add(l2);
        statusText = new JTextField();
        l2.setLabelFor(statusText);
        form.add(statusText);
        SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, 6, 6);

        contentPane.add(scrollPane);
        contentPane.add(menu);
        contentPane.add(form);
        revalidate();
    }

    public void getTableAllUsersButton(){
        model2 = new AccountManagement.AllUsers();
        sorter2 = new TableRowSorter<AccountManagement.AllUsers>(model2);
        table = new JTable(model2);
        table.setRowSorter(sorter2);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            statusText.setText("");
                        } else {
                            int modelRow =
                                    table.convertRowIndexToModel(viewRow);
                            statusText.setText(
                                    String.format("Selected Row in view: %d. " +
                                                    "Selected Row in model: %d.",
                                            viewRow, modelRow));
                        }
                    }
                }
        );
        scrollPane = new JScrollPane(table);
        form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField();
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter2();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter2();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter2();
                    }
                });
        l1.setLabelFor(filterText);
        form.add(filterText);
        JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
        form.add(l2);
        statusText = new JTextField();
        l2.setLabelFor(statusText);
        form.add(statusText);
        SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, 6, 6);

        contentPane.add(scrollPane);
        contentPane.add(form);
        revalidate();
    }

    private void newFilter1() {
        RowFilter<AccountManagement.AllAccounts, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter1.setRowFilter(rf);
    }

    private void newFilter2() {
        RowFilter<AccountManagement.AllUsers, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter2.setRowFilter(rf);
    }

    class AllUsers extends AbstractTableModel {
        private String[] columnNames = {"USER ID",
                "NAME",
                "ID ACCOUNT",
                "ADDRESS",
                "ROLE"};

        private ArrayList<UserPOJO> data;

        public AllUsers(){
            data = new ArrayList<>();
            data = UserBUS.getAll();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            UserPOJO p = data.get(row);

            if(col == 0){
                return p.getId();
            }
            if(col == 1){
                return p.getName();
            }
            if(col == 2){
                return p.getIdAccount();
            }
            if(col == 3){
                return p.getAddress();
            }

                return p.getRole();


        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }

        }
    }

    class AllAccounts extends AbstractTableModel {
        private String[] columnNames = {"ID",
                "USERNAME",
                "PASSWORD",
                "IS ACTIVE"};

        private ArrayList<AccountPOJO> data;

        public AllAccounts(){
            data = new ArrayList<>();
            data = AccountBUS.getAll();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            AccountPOJO p = data.get(row);

            if(col == 0){
                return p.getId();
            }
            if(col == 1){
                return p.getUsername();
            }

            if(col == 2){
                return p.getPassword();
            }
            return p.getIsActive();


        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }

        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin - Book Management");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setLayout(new BorderLayout(0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        AccountManagement newContentPane = new AccountManagement();
        newContentPane.setOpaque(true); //content panes must be opaque
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
