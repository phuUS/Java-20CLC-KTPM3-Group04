package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BUS.AccountBUS;
import BUS.UserBUS;
import POJO.AccountPOJO;
import POJO.UserPOJO;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import BUS.BookBUS;
import BUS.PublisherBUS;
import POJO.BookPOJO;
import POJO.PublisherPOJO;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class AdminControllerGUI extends JFrame {

	private JPanel contentPane;
	private final JPanel topPane = new JPanel();

	String username;
	AccountManagement accountManagement;
	UserPOJO user;

	BookManagement bookControlGUI;
	PromotionManagement promotionControlGUI;
	importSheet importSheetControlGUI;
	AuthorGUI authorControlGUI;
	ViewOrdersFrame orderControlGUI;
	ViewBookCategoriesFrame bookCategoryControlGUI;
	publisherGUI publisherControlGUI;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				AdminControllerGUI frame = new AdminControllerGUI(username);
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

public UserPOJO getUser(){
	ArrayList<AccountPOJO> accountList = AccountBUS.getAll();
        ArrayList<UserPOJO> userList = UserBUS.getAll();
        UserPOJO userTemp = null;
        for(AccountPOJO a : accountList) {
            if(a != null && a.getUsername().equals(username)) {
                userTemp = userList.stream().filter(u -> a.getId().equals(u.getIdAccount())).findFirst().orElse(null);
            }
        }
		return userTemp;
}

	/**
	 * Create the frame.
	 */
	public AdminControllerGUI(String username) {
		this.setUsername(username);
		user = this.getUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		topPane.setBounds(0, 0, 649, 31);
		contentPane.add(topPane);
		topPane.setLayout(null);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(10, 10, 85, 21);
		topPane.add(logoutBtn);
		
		JButton editInfoBtn = new JButton("Edit info");
		editInfoBtn.setBounds(109, 10, 85, 21);
		editInfoBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InfoFormPanel infoFormPanel = new InfoFormPanel();
				infoFormPanel.setVisible(true);
			}

		});
		topPane.add(editInfoBtn);
		
		JLabel userControlLabel = new JLabel("USER CONTROL");
		userControlLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		userControlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userControlLabel.setBounds(221, 41, 212, 31);
		contentPane.add(userControlLabel);
		
		JLabel greetingLabel = new JLabel("Welcome, Username");
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		greetingLabel.setBounds(209, 66, 268, 31);
		contentPane.add(greetingLabel);
		
		JButton accountManagementBtn = new JButton("Account Management");
		accountManagementBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				accountManagement = new AccountManagement();
				accountManagement.createAndShowGUI();
				hideAdminControl();
			}
			
		});
		accountManagementBtn.setBounds(10, 146, 132, 31);
		contentPane.add(accountManagementBtn);

		
		
		JButton importSheetBtn = new JButton("View statistics");
		importSheetBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bookControlGUI = new BookManagement();
				bookControlGUI.setVisible(true);
				hideAdminControl();
			}
			
		});
		importSheetBtn.setBounds(10, 230, 132, 31);
		contentPane.add(importSheetBtn);
		
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("src/images/hieu-sach-nha-nam-214377.jpg"));
			JLabel imageLable = new JLabel(new ImageIcon(image));
			imageLable.setBounds(152, 129, 345, 253);
			contentPane.add(imageLable);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private void hideAdminControl(){
		this.setVisible(false);
	}

	class InfoFormPanel extends JDialog implements ActionListener{
        JLabel headLabel;

        JLabel idLabel;
        JTextField idField;

        JLabel nameLabel;
        JTextField nameField;

        JLabel addressLabel;
        JTextField addressField;

        JLabel idAccountLabel;
        JTextField idAccountField;

        JLabel roleLabel;
        JTextField roleField;

        JButton clearButton;
        JButton addButton;

        GridBagConstraints gbc;


        InfoFormPanel(){
            this.setSize(700, 300);
            this.setLocationRelativeTo(null);
            this.setResizable(true);
            setLayout(new GridBagLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.initComponent();
            this.setVisible(true);
        }
        public void initComponent() {
            headLabel = new JLabel("User's information");
			headLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(221, 41, 212, 31);

            idLabel = new JLabel("ID:");
            idField = new JTextField(user.getId());

            nameLabel = new JLabel("Name:");
            nameField = new JTextField(user.getName());

            ArrayList<PublisherPOJO> publishers = PublisherBUS.getAll();
            ArrayList<String> publisherModel = new ArrayList<>();
            for (PublisherPOJO publisher : publishers){
                publisherModel.add(publisher.getId() + " - " + publisher.getName());
            }

            addressLabel = new JLabel("Address:");
            addressField = new JTextField(user.getAddress());

            idAccountLabel = new JLabel("ID Account:");
            idAccountField = new JTextField(user.getIdAccount());
            roleLabel = new JLabel("Role: ");
			String roleString = user.getRole() == 1 ? "Admin" : "User";
            roleField = new JTextField(roleString);
            

            clearButton = new JButton("Clear");
            clearButton.addActionListener(this);

            addButton = new JButton("Update");
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
            add(addressLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = i++;
            add(roleLabel, gbc);

			gbc.gridx = 0;
            gbc.gridy = i++;
            add(idAccountLabel, gbc);

            

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
            add(addressField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(roleField, gbc);

            gbc.gridx = 1;
            gbc.gridy = i++;
            add(idAccountField, gbc);

            

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
                addressField.setText("");
                roleField.setText("");
                idAccountField.setText("");
            }
            else if (e.getSource() == addButton){
                try {
                    UserPOJO book = new UserPOJO(
                            idField.getText(),
                            nameField.getText(),
							idAccountField.getText(),
							addressField.getText(),
							Boolean.parseBoolean(roleField.getText())
					);
					UserBUS userBUS = new UserBUS();
                    Boolean result = userBUS.update(book);
                    if (result){
                        JOptionPane.showMessageDialog(this, "Update success!", "Success", JOptionPane.PLAIN_MESSAGE);
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
