package GUI;

import BUS.BookBUS;
import BUS.PublisherBUS;
import POJO.BookPOJO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BookManagement extends JFrame implements ActionListener {
    JPanel menuPane;
    JButton backButton;


    final int SIDEBAR_PANE_WIDTH = 170;
    JPanel sidebarPane;
    JButton allBooksButton;
    JButton newBooksButton;
    JButton hotBooksButton;
    JButton addBookButton;
    JButton outOfStockBooksButton;


    JPanel contentPane;
    JLabel contentLabel;
    JTable bookTable;
    JScrollPane bookTableScroll;
    AddBookFormPanel addBookFormPanel;


    public BookManagement() {
        setTitle("Employee - Book Management");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout(0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLUE);
        initComponent();
        this.setVisible(true);
    }

    private void initComponent(){
        menuPane = new JPanel();
        menuPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPane.setBackground(Color.CYAN);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        menuPane.add(backButton);


        sidebarPane = new JPanel();
        sidebarPane.setLayout(new BoxLayout(sidebarPane, BoxLayout.Y_AXIS));
        sidebarPane.setPreferredSize(new Dimension(SIDEBAR_PANE_WIDTH, 0));
        sidebarPane.setBorder(new LineBorder(Color.BLACK, 3));
        sidebarPane.setBackground(Color.GREEN);

        allBooksButton = new JButton("All Books");
        allBooksButton.setMaximumSize(new Dimension(SIDEBAR_PANE_WIDTH, 30));
        allBooksButton.setFocusable(false);
        allBooksButton.addActionListener(this);

        newBooksButton = new JButton("New Books");
        newBooksButton.setMaximumSize(new Dimension(SIDEBAR_PANE_WIDTH, 30));
        newBooksButton.setFocusable(false);
        newBooksButton.addActionListener(this);

        hotBooksButton = new JButton("Hot Books");
        hotBooksButton.setMaximumSize(new Dimension(SIDEBAR_PANE_WIDTH, 30));
        hotBooksButton.setFocusable(false);
        hotBooksButton.addActionListener(this);

        outOfStockBooksButton = new JButton("Out Of Stock Books");
        outOfStockBooksButton.setMaximumSize(new Dimension(SIDEBAR_PANE_WIDTH, 30));
        outOfStockBooksButton.setFocusable(false);
        outOfStockBooksButton.addActionListener(this);

        addBookButton = new JButton("Add New Book");
        addBookButton.setMaximumSize(new Dimension(SIDEBAR_PANE_WIDTH, 30));
        addBookButton.setFocusable(false);
        addBookButton.addActionListener(this);


        sidebarPane.add(allBooksButton);
        sidebarPane.add(newBooksButton);
        sidebarPane.add(hotBooksButton);
        sidebarPane.add(outOfStockBooksButton);
        sidebarPane.add(addBookButton);



        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentLabel = new JLabel();
        contentLabel.setText("Please choose an action in the sidebar...");
        contentLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        bookTableScroll = new JScrollPane();

        contentPane.add(contentLabel);


        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);
    }

    public JTable getAllBooksTable() {
        String[] col ={"ID","NAME","ID PUBLISHER", "PRICE", "STOCK", "TOTAL PURCHASE" , "STATUS", "ACTION", "EDIT"};
        ArrayList<BookPOJO> allBooks = BookBUS.getAll();

        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (BookPOJO book : allBooks) {
            String id = book.getId();
            String name = book.getName();
            String idPublisher = book.getIdPublisher();
            Integer price = book.getPrice();
            Integer stock = book.getStock();
            Integer totalPurchase = book.getTotalPurchase();
            String enabled = book.isEnabled() ? "Enabled" : "Disabled";
            String action = book.isEnabled() ? "Disable" : "Enable";

            Object[] data = {id, name, idPublisher, price, stock, totalPurchase, enabled, action, "Edit"};
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
        table.getColumn("ACTION").setCellRenderer(new ButtonRenderer());
        table.getColumn("ACTION").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("EDIT").setCellRenderer(new ButtonRenderer());
        table.getColumn("EDIT").setCellEditor(new ButtonEditor(new JCheckBox()));
        return table;
    }

    // class methods
    public void refreshAllBooksTable(){
        contentLabel.setText("All Books List");
        contentPane.add(contentLabel);
        bookTable = getAllBooksTable();
        bookTableScroll.setViewportView(bookTable);
        contentPane.add(bookTableScroll);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contentPane.removeAll();

        if (e.getSource() == allBooksButton){
            refreshAllBooksTable();
        }
        else if (e.getSource() == addBookButton){
            addBookFormPanel = new AddBookFormPanel();
            contentLabel.setText("Add A New Book");
            contentPane.add(contentLabel);
            contentPane.add(addBookFormPanel);
        }
        revalidate();
        repaint();
    }


    // local classes
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
                String bookId = bookTable.getValueAt(row, 0).toString();
                if (Objects.equals(type, "Enable")) {
                    BookBUS.enable(bookId);
                    refreshAllBooksTable();
                } else if (Objects.equals(type, "Disable")){
                    BookBUS.disable(bookId);
                    refreshAllBooksTable();
                } else if (Objects.equals(type, "Edit")){
                    new EditBookDialog(BookManagement.this, "Edit Book", true, bookId);
                    refreshAllBooksTable();
                } else {
                    System.out.println("ERROR: " + bookTable.getValueAt(row, 0) + " - " + type);
                }
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

    public static class EditBookDialog extends JDialog implements ActionListener {
        BookPOJO book;

        JLabel headLabel;

        JLabel idLabel;
        JTextField idField;

        JLabel nameLabel;
        JTextField nameField;

        JLabel publisherIdLabel;
        JComboBox<String> publisherIdField;

        JLabel priceLabel;
        JTextField priceField;

        JLabel stockLabel;
        JTextField stockField;

        JLabel totalPurchaseLabel;
        JTextField totalPurchaseField;

        JLabel statusLabel;
        JComboBox<String> statusField;

        JButton cancelButton;
        JButton saveButton;

        GridBagConstraints gbc;


        EditBookDialog(JFrame parent, String title, boolean modal, String bookId){
            super(parent, title, modal);
            this.book = BookBUS.getOne(bookId);

            this.setSize(700, 500);
            this.setLocationRelativeTo(null);
            this.setResizable(true);
            setLayout(new GridBagLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.initComponent();
            this.setVisible(true);
        }
        public void initComponent() {
            headLabel = new JLabel("You are editing book ID: " + book.getId());

            idLabel = new JLabel("ID:");
            idField = new JTextField(book.getId());

            nameLabel = new JLabel("Name:");
            nameField = new JTextField(book.getName());

            publisherIdLabel = new JLabel("Publisher ID:");
            String[] publishers = PublisherBUS.getAllId().toArray(new String[0]);
            publisherIdField = new JComboBox<>(publishers);
            publisherIdField.setSelectedItem(book.getIdPublisher());

            priceLabel = new JLabel("Price:");
            priceField = new JTextField(book.getPrice().toString());
            priceField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    priceField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            stockLabel = new JLabel("Left In Stock:");
            stockField = new JTextField(book.getStock().toString());
            stockField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    stockField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            totalPurchaseLabel = new JLabel("Total Purchased Number:");
            totalPurchaseField = new JTextField(book.getTotalPurchase().toString());
            totalPurchaseField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    totalPurchaseField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            statusLabel = new JLabel("Status:");
            String[] statuses = {"Enabled", "Disabled"};
            statusField = new JComboBox<>(statuses);
            String status = book.isEnabled() ? "Enabled" : "Disabled";
            statusField.setSelectedItem(status);


            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(this);

            saveButton = new JButton("Save");
            saveButton.addActionListener(this);


            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 20, 5, 20);

            gbc.fill = GridBagConstraints.BOTH;

            //add labels
            int i;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(headLabel, gbc);
            i = 2;

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(idLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(nameLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(publisherIdLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(priceLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(stockLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(totalPurchaseLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i;
            add(statusLabel, gbc);

            //add fields
            gbc.weightx = 2;
            i = 2;
            gbc.gridx = 1;
            gbc.gridy = i++;
            add(idField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(nameField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(publisherIdField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(priceField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(stockField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(totalPurchaseField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(statusField, gbc);

            //add buttons
            gbc.weightx = 1;
            gbc.gridx = 0;
            gbc.gridy = i;
            add(cancelButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            add(saveButton, gbc);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cancelButton){
                this.dispose();
            }
            else if (e.getSource() == saveButton){
                BookPOJO modifiedBook = new BookPOJO(
                        idField.getText(),
                        nameField.getText(),
                        Objects.requireNonNull(publisherIdField.getSelectedItem()).toString(),
                        Integer.parseInt(priceField.getText()),
                        Integer.parseInt(stockField.getText()),
                        Integer.parseInt(totalPurchaseField.getText()),
                        statusField.getSelectedItem() == "Enabled");

                Boolean result = BookBUS.updateOne(book.getId(),modifiedBook);
                if (result){
                    JOptionPane.showMessageDialog(this, "Update success!", "Success", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Something went wrong...", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    static class AddBookFormPanel extends JPanel implements ActionListener{
        JLabel headLabel;

        JLabel idLabel;
        JTextField idField;

        JLabel nameLabel;
        JTextField nameField;

        JLabel publisherIdLabel;
        JComboBox<String> publisherIdField;

        JLabel priceLabel;
        JTextField priceField;

        JLabel stockLabel;
        JTextField stockField;

        JLabel totalPurchaseLabel;
        JTextField totalPurchaseField;

        JLabel statusLabel;
        JComboBox<String> statusField;

        JButton clearButton;
        JButton addButton;

        GridBagConstraints gbc;


        AddBookFormPanel(){
            setLayout(new GridBagLayout());
            this.initComponent();
        }
        public void initComponent() {
            headLabel = new JLabel("Book's information");

            idLabel = new JLabel("ID:");
            idField = new JTextField();

            nameLabel = new JLabel("Name:");
            nameField = new JTextField();

            publisherIdLabel = new JLabel("Publisher ID:");
            String[] publishers = PublisherBUS.getAllId().toArray(new String[0]);
            publisherIdField = new JComboBox<>(publishers);

            priceLabel = new JLabel("Price:");
            priceField = new JTextField();
            priceField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    priceField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            stockLabel = new JLabel("Left In Stock:");
            stockField = new JTextField();
            stockField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    stockField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            totalPurchaseLabel = new JLabel("Total Purchased Number:");
            totalPurchaseField = new JTextField();
            totalPurchaseField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    totalPurchaseField.setEditable(key >= '0' && key <= '9' || key == '\b');
                }
            });

            statusLabel = new JLabel("Status:");
            String[] statuses = {"Enabled", "Disabled"};
            statusField = new JComboBox<>(statuses);

            clearButton = new JButton("Clear");
            clearButton.addActionListener(this);

            addButton = new JButton("Add");
            addButton.addActionListener(this);


            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 20, 5, 20);

            gbc.fill = GridBagConstraints.BOTH;

            //add labels
            int i;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(headLabel, gbc);
            i = 2;

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(idLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(nameLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(publisherIdLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(priceLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(stockLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(totalPurchaseLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i;
            add(statusLabel, gbc);

            //add fields
            gbc.weightx = 2;
            i = 2;
            gbc.gridx = 1;
            gbc.gridy = i++;
            add(idField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(nameField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(publisherIdField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(priceField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(stockField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(totalPurchaseField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(statusField, gbc);

            //add buttons
            gbc.weightx = 1;
            gbc.gridx = 0;
            gbc.gridy = i;
            add(clearButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            add(addButton, gbc);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton){
                idField.setText("");
                nameField.setText("");
                publisherIdField.setSelectedIndex(0);
                priceField.setText("");
                stockField.setText("");
                totalPurchaseField.setText("");
                statusField.setSelectedIndex(0);
            }
            else if (e.getSource() == addButton){
                try {
                    BookPOJO book = new BookPOJO(
                            idField.getText(),
                            nameField.getText(),
                            Objects.requireNonNull(publisherIdField.getSelectedItem()).toString(),
                            Integer.parseInt(priceField.getText()),
                            Integer.parseInt(stockField.getText()),
                            Integer.parseInt(totalPurchaseField.getText()),
                            statusField.getSelectedItem() == "Enabled");
                    Boolean result = BookBUS.insertOne(book);
                    if (result){
                        JOptionPane.showMessageDialog(this, "Add new book success!", "Success", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Something went wrong..., please review the " +
                                "information", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(this, "Invalid Information, please check again!");
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            }
        }

    }
}

