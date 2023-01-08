package GUI;

import BUS.AccountBUS;
import BUS.UserBUS;
import DAO.AccountDAO;
import GUI.AdminManagement.ButtonEditor;
import GUI.AdminManagement.ButtonRenderer;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class AdminManagement extends JPanel implements ActionListener {
    private JPanel menuPane;
    private JButton backBtn;
    JTable accountTable;

    private JButton editInfoButton;
    JButton selectedButton;

    private final int SIDEBARPANE_WIDTH = 180;
    private JPanel sidebarPane;
    private JButton allAccountsButton;
    private JButton allUserButton;
    JScrollPane accountTableScroll;

    private JButton addNewAccount;

    private JPanel contentPane;
    private JLabel contentLabel;
    static JFrame frame;

    private String username;
    private AdminControllerGUI adminControllerGUI;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdminManagement() {
        super();
        setLayout(new BorderLayout(0, 0));

        menuPane = new JPanel();
        menuPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPane.setBackground(Color.GRAY);

        backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                adminControllerGUI = new AdminControllerGUI(username);
                adminControllerGUI.setVisible(true);
                hideFrame();
            }

        });
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        menuPane.add(backBtn);

        // editInfoButton = new JButton("Information");
        // editInfoButton.setFocusable(false);
        // editInfoButton.addActionListener(this);
        // menuPane.add(editInfoButton);

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
        accountTableScroll = new JScrollPane();
        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);
    }

    public JTable getTableAllAccounts() {
        ArrayList<AccountPOJO> accountList = AccountDAO.getAll();

        JTable table = new JTable();
        String[] col = { "ID", "USERNAME", "PASSWORD", "STATUS", "ACTION", "EDIT" };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        if (accountList != null) {
            for (AccountPOJO account : accountList) {
                String id = account.getId();
                String username = account.getUsername();
                String password = account.getPassword();
                Boolean isActive = account.getIsActive();

                String enabled = isActive ? "Enabled" : "Disabled";
                String status = isActive ? "Active" : "Inactive";
                Object[] data = { id, username, password, status, enabled, "Edit" };
                tableModel.addRow(data);
            }
        }
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
        table.getColumn("ACTION").setCellRenderer(new ButtonRenderer());
        table.getColumn("ACTION").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("EDIT").setCellRenderer(new ButtonRenderer());
        table.getColumn("EDIT").setCellEditor(new ButtonEditor(new JCheckBox()));
        return table;
    }

    public void hideFrame() {
        frame.setVisible(false);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        private String label;

        private boolean isPushed;
        int row;
        int column;
        String type;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            type = label;
            isPushed = true;
            this.row = row;
            this.column = column;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                String accountId = accountTable.getValueAt(row, 0).toString();
                // if (Objects.equals(type, "Enable")) {
                // AccountBUS.enable(accountId);
                // refreshBookTable();
                // } else if (Objects.equals(type, "Disable")) {
                // AccountBUS.disable(accountId);
                // refreshAccountTable();
                // } else if (Objects.equals(type, "Edit")) {
                // new EditBookDialog(AdminManagement.this, "Edit Book", true, accountId);
                // refreshAccountTable();
                // } else {
                // System.out.println("Unknown action: " + accountTable.getValueAt(row, 0) + " -
                // " + type);
                // }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public void refreshAccountTable() {
        contentLabel.setText(selectedButton.getText() + " List");
        contentPane.add(contentLabel);
        accountTable = getTableAllAccounts();
        accountTableScroll.setViewportView(accountTable);
        contentPane.add(accountTableScroll);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contentPane.removeAll();
        selectedButton = (JButton) e.getSource();
        if (selectedButton == allAccountsButton) {
            refreshAccountTable();
        }
        revalidate();
        repaint();
    }

    public void createAndShowGUI() {
        // Create and set up the window.
        frame = new JFrame("Admin - Book Management");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setLayout(new BorderLayout(0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        AdminManagement newContentPane = new AdminManagement();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminManagement adminManagement = new AdminManagement();
                adminManagement.createAndShowGUI();
            }
        });
    }
}
