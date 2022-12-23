package GUI;

import BUS.AccountBUS;
import POJO.AccountPOJO;

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

    final int SIDEBARPANE_WIDTH = 150;
    JPanel sidebarPane;
    JButton allAccountsButton;

    JPanel contentPane;
    JLabel contentLabel;
    JTable accountTable;
    JScrollPane accountTableScroll;

    private boolean DEBUG = false;
    private JTable table;
    private JTextField filterText;
    private JTextField statusText;
    private TableRowSorter<AccountManagement.MyTableModel> sorter;

    public AccountManagement() {
        super();
        setLayout(new BorderLayout(0,0));


        //Create a table with a sorter.
        AccountManagement.MyTableModel model = new AccountManagement.MyTableModel();
        sorter = new TableRowSorter<AccountManagement.MyTableModel>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);


        //For the purposes of this example, better to have a single
        //selection.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //When selection changes, provide account with row numbers for
        //both view and model.
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            //Selection got filtered away.
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


        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
//        add(scrollPane);

        //Create a separate form for filterText and statusText
        JPanel form = new JPanel(new SpringLayout());
        JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
        form.add(l1);
        filterText = new JTextField();
        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
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
//        add(form);


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

        sidebarPane.add(allAccountsButton);

//        contentPane = new JPanel();
//        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
//
//        contentLabel = new JLabel();
//        contentLabel.setText("All of accounts list");
//
//        accountTable = null;
//        accountTableScroll = new JScrollPane(accountTable);

        contentPane.add(scrollPane);
        contentPane.add(form);

        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
    }

    public JTable getAllAccountsTable() {
        String col[]={"ID","accountNAME","PASSWORD"};
        ArrayList<AccountPOJO> allAccounts = AccountBUS.getAll();

        JTable result = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < allAccounts.size(); i++){
            String id = allAccounts.get(i).getId();
            String username = allAccounts.get(i).getUsername();
            String password = allAccounts.get(i).getPassword();
            Object[] data = {id, username, password};
            tableModel.addRow(data);
        }
        result.setModel(tableModel);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allAccountsButton){
            if (accountTable != null) {
                contentPane.remove(accountTable);
            }
            accountTable = getAllAccountsTable();
            accountTableScroll.setViewportView(accountTable);
            contentPane.add(accountTableScroll);
            contentLabel.setText("Here are all the accounts");
            revalidate();
        }
    }

    private void newFilter() {
        RowFilter<AccountManagement.MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }




    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"ID",
                "USERNAME",
                "PASSWORD"};

        private ArrayList<AccountPOJO> data;

        public MyTableModel(){
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
            else if(col == 1){
                return p.getUsername();
            }
            else {
                return p.getPassword();
            }
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }

        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
            System.out.println("--------------------------");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin - Book Management");
        frame.setSize(1000, 700);
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
