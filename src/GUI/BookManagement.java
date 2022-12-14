package GUI;

import BUS.BookBUS;
import POJO.BookPOJO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookManagement extends JFrame implements ActionListener {
    JPanel menuPane;
    JButton backButton;


    final int SIDEBARPANE_WIDTH = 150;
    JPanel sidebarPane;
    JButton allBooksButton;


    JPanel contentPane;
    JLabel contentLable;
    JTable bookTable;
    JScrollPane bookTableScroll;


    public BookManagement() {
        setTitle("Employee - Book Management");
        setSize(1000, 700);
        setBackground(Color.BLUE);
        setLayout(new BorderLayout(0,0));


        menuPane = new JPanel();
        menuPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPane.setBackground(Color.CYAN);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        menuPane.add(backButton);


        sidebarPane = new JPanel();
        sidebarPane.setLayout(new BoxLayout(sidebarPane, BoxLayout.Y_AXIS));
        sidebarPane.setPreferredSize(new Dimension(SIDEBARPANE_WIDTH, 0));
        sidebarPane.setBorder(new LineBorder(Color.BLACK, 3));
        sidebarPane.setBackground(Color.GREEN);

        allBooksButton = new JButton("All Books");
        allBooksButton.setMaximumSize(new Dimension(SIDEBARPANE_WIDTH, 30));
        allBooksButton.setFocusable(false);
        allBooksButton.addActionListener(this);

        sidebarPane.add(allBooksButton);



        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentLable = new JLabel();
        contentLable.setText("Click sidebar button to get Books");

        bookTable = null;
        bookTableScroll = new JScrollPane(bookTable);

        contentPane.add(contentLable);
        contentPane.add(bookTableScroll);



        add(menuPane, BorderLayout.NORTH);
        add(sidebarPane, BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getAllBooksTable() {
        String col[]={"ID","NAME","ID PUBLISHER", "PRICE"};
        ArrayList<BookPOJO> allBooks = BookBUS.getAll();

        JTable result = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < allBooks.size(); i++){
            String id = allBooks.get(i).getId();
            String name = allBooks.get(i).getName();
            String idPublisher = allBooks.get(i).getIdPublisher();
            Integer price = allBooks.get(i).getPrice();

            Object[] data = {id, name, idPublisher, price};
            tableModel.addRow(data);
        }
        result.setModel(tableModel);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allBooksButton){
            if (bookTable != null) {
                contentPane.remove(bookTable);
            }
            bookTable = getAllBooksTable();
            bookTableScroll.setViewportView(bookTable);
            contentPane.add(bookTableScroll);
            contentLable.setText("Here are all the books");
            revalidate();
        }
    }
}
