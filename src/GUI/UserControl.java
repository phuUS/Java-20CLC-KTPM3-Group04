package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class UserControl extends JFrame {

	private JPanel contentPane;
	private final JPanel topPane = new JPanel();
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserControl frame = new UserControl();
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
	public UserControl() {
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
		
		JButton BookManageBtn = new JButton("Book Management");
		BookManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bookControlGUI = new BookManagement();
				hideUserControl();
			}
			
		});
		BookManageBtn.setBounds(10, 146, 132, 31);
		contentPane.add(BookManageBtn);

		JButton PromotionManageBtn = new JButton("Promotion Management");
		PromotionManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				promotionControlGUI = new PromotionManagement();
				promotionControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});

		PromotionManageBtn.setBounds(10, 177, 132, 31);
		contentPane.add(PromotionManageBtn);
		
		JButton importSheetBtn = new JButton("Import Sheet");
		importSheetBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				importSheetControlGUI = new importSheet();
				importSheetControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});
		importSheetBtn.setBounds(10, 230, 132, 31);
		contentPane.add(importSheetBtn);
		
		JButton authorManageBtn = new JButton("Author Management");
		authorManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				authorControlGUI = new AuthorGUI();
				authorControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});
		authorManageBtn.setBounds(10, 316, 132, 31);
		contentPane.add(authorManageBtn);
		
		JButton orderManageBtn = new JButton("Order Management");
		orderManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				orderControlGUI = new ViewOrdersFrame()	;
				orderControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});
		orderManageBtn.setBounds(507, 146, 132, 31);
		contentPane.add(orderManageBtn);
		
		JButton categoryManageBtn = new JButton("Category Management");
		categoryManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bookCategoryControlGUI = new ViewBookCategoriesFrame();
				bookCategoryControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});
		categoryManageBtn.setBounds(507, 230, 132, 31);
		contentPane.add(categoryManageBtn);
		
		JButton publisherManageBtn = new JButton("Publisher Management");
		publisherManageBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				publisherControlGUI = new publisherGUI();
				publisherControlGUI.setVisible(true);
				hideUserControl();
			}
			
		});
		publisherManageBtn.setBounds(507, 316, 132, 31);
		contentPane.add(publisherManageBtn);
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

	private void hideUserControl(){
		this.setVisible(false);
	}
}
