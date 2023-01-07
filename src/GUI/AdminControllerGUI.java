package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class AdminControllerGUI extends JFrame {

	private JPanel contentPane;
	private final JPanel topPane = new JPanel();

	String username;
	AccountManagement accountManagement;

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
}