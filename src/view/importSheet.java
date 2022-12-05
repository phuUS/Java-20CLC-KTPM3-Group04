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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;

public class importSheet extends JFrame {

	private JPanel contentPane;
	private JTextField employeeInput;
	private JTextField idInput;
	private JTable listImportBookTable;
	private JTextField totalCostInput;
	private JTextField employeeNameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					importSheet frame = new importSheet();
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
	public importSheet() {
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
		
		JButton importBookBtn = new JButton("Import Book");
		importBookBtn.setBounds(10, 60, 153, 41);
		sidebarPane.add(importBookBtn);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(193, 30, 2, 624);
		contentPane.add(separator_2);
		
		JPanel mainContentPane = new JPanel();
		mainContentPane.setBounds(205, 42, 741, 612);
		contentPane.add(mainContentPane);
		mainContentPane.setLayout(null);
		
		JLabel IPSBookLabel = new JLabel("IMPORT SHEET BOOK");
		IPSBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IPSBookLabel.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		IPSBookLabel.setBounds(170, 10, 392, 41);
		mainContentPane.add(IPSBookLabel);
		
		JLabel CommonInfoLabel = new JLabel("Common Infomation");
		CommonInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CommonInfoLabel.setBounds(32, 66, 143, 25);
		mainContentPane.add(CommonInfoLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(172, 78, 569, 2);
		mainContentPane.add(separator);
		
		JLabel employeeLabel = new JLabel("Employee_ID");
		employeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		employeeLabel.setBounds(10, 182, 112, 25);
		mainContentPane.add(employeeLabel);
		
		employeeInput = new JTextField();
		employeeInput.setBounds(127, 180, 166, 34);
		mainContentPane.add(employeeInput);
		employeeInput.setColumns(10);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel.setBounds(10, 124, 100, 30);
		mainContentPane.add(idLabel);
		
		idInput = new JTextField();
		idInput.setBounds(127, 125, 166, 34);
		mainContentPane.add(idInput);
		idInput.setColumns(10);
		
		JLabel dayLabel = new JLabel("Day:");
		dayLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLabel.setBounds(350, 192, 46, 19);
		mainContentPane.add(dayLabel);
		
		JComboBox dayComboBox = new JComboBox();
		
		for (int i = 1; i <= 31; i++) {
			dayComboBox.addItem(""+i);
		}
		dayComboBox.setBounds(399, 186, 46, 25);
		mainContentPane.add(dayComboBox);
		
		JLabel monthLabel = new JLabel("Month:");
		monthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthLabel.setBounds(455, 192, 54, 19);
		mainContentPane.add(monthLabel);
		
		JComboBox monthComboBox = new JComboBox();
		
		for (int i = 1; i <= 12; i++) {
			monthComboBox.addItem(""+i);
		}
		monthComboBox.setBounds(504, 186, 46, 25);
		mainContentPane.add(monthComboBox);
		
		JLabel yearLabel = new JLabel("Year:");
		yearLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearLabel.setBounds(561, 189, 66, 25);
		mainContentPane.add(yearLabel);
		
		JComboBox yearComboBox = new JComboBox();
		
		for (int i = 2022; i<=2030; i++) {
			yearComboBox.addItem(""+i);
		}
		yearComboBox.setBounds(598, 186, 66, 25);
		mainContentPane.add(yearComboBox);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateLabel.setBounds(351, 157, 78, 25);
		mainContentPane.add(dateLabel);
		
		JLabel listImportBookLabel = new JLabel("List Imported Book");
		listImportBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listImportBookLabel.setBounds(32, 241, 143, 25);
		mainContentPane.add(listImportBookLabel);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(155, 254, 586, 2);
		mainContentPane.add(separator_3);
		
		JScrollPane listImportBookPane = new JScrollPane();
		listImportBookPane.setBounds(10, 301, 731, 218);
		mainContentPane.add(listImportBookPane);
		
		JScrollBar listImportBookScrollBar = new JScrollBar();
		listImportBookPane.setRowHeaderView(listImportBookScrollBar);
		
		String data[][] = {{"SACH01","Nhà giả kim","NXB01","3","50000"},
							{"SACH02","Đắc Nhân Tâm","NXB02","5","50000"},
							{"SACH03","Lỗ Đen","NXB04","10","20000"}};
		String[] columnNames = {"ID", "Name", "ID_Publisher","Quantity","Price Per One"};
		
		listImportBookTable = new JTable(data, columnNames);
		listImportBookPane.setViewportView(listImportBookTable);
		
		JButton addRowBtn = new JButton("Add row");
		addRowBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addRowBtn.setBounds(500, 266, 97, 25);
		mainContentPane.add(addRowBtn);
		
		JButton deleteRowBtn = new JButton("Delete row");
		deleteRowBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteRowBtn.setBounds(607, 266, 124, 25);
		mainContentPane.add(deleteRowBtn);
		
		JLabel totalCostLabel = new JLabel("Total Cost");
		totalCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalCostLabel.setBounds(10, 532, 66, 25);
		mainContentPane.add(totalCostLabel);
		
		totalCostInput = new JTextField();
		totalCostInput.setBounds(92, 537, 96, 19);
		mainContentPane.add(totalCostInput);
		totalCostInput.setColumns(10);
		
		JLabel vndLabel = new JLabel("VND");
		vndLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vndLabel.setBounds(198, 538, 46, 17);
		mainContentPane.add(vndLabel);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelBtn.setBounds(500, 577, 85, 25);
		mainContentPane.add(cancelBtn);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(607, 577, 85, 25);
		mainContentPane.add(saveBtn);
		
		JLabel employeeNameLabel = new JLabel("Employee_name");
		employeeNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		employeeNameLabel.setBounds(350, 124, 124, 24);
		mainContentPane.add(employeeNameLabel);
		
		employeeNameInput = new JTextField();
		employeeNameInput.setBounds(466, 124, 198, 35);
		mainContentPane.add(employeeNameInput);
		employeeNameInput.setColumns(10);
		
		
	}
}