import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.Label;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;

public class adminentry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final JPanel panel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminentry frame = new adminentry();
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
	public adminentry() {
		setTitle("ADMIN_ENTRY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 759);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("BLOOD GROUP :");
		label.setBounds(173, 15, 111, 21);
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label);
		label.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(309, 12, 161, 24);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "AB", "AB+", "AB-", "O", "O+", "O-"}));
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		
		Label label_1 = new Label("DISTRICT :");
		label_1.setBounds(173, 49, 111, 21);
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_1);
		label_1.setVisible(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(309, 48, 161, 24);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "ALAPPUZHA", "ERNAKULAM", "IDUKKI", "KANNUR", "KASARAGOD", "KOLLLAM", "KOTTAYAM", "KOZHIKODE", "MALAPPURAM", "PALAKKAD", "PATHANAMTHITTA", "THIRUVANANTHAPURA", "THRISSUR", "WAYANAD"}));
		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);
		
		Label label_8 = new Label("username :");
		label_8.setBounds(580, 223, 88, 21);
		contentPane.add(label_8);
		label_8.setVisible(false);
		
		Label label_9 = new Label("password :");
		label_9.setBounds(580, 268, 88, 21);
		contentPane.add(label_9);
		label_9.setVisible(false);
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(669, 220, 187, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(669, 270, 187, 19);
		contentPane.add(passwordField);
		passwordField.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 366, 790, 309);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel(0,0) {
			@Override
			public boolean isCellEditable(int row,int col)
			{
				return false;
			}
		};
		table = new JTable();
		scrollPane.setViewportView(table);
       
		String []headerStrings = {"DR_ID","NAME","BLOOD_GROUP","PHONE_NO"};
		model.setColumnIdentifiers(headerStrings);
		table.setModel(model);
		
		model.getDataVector().removeAllElements();
		table.getTableHeader().setReorderingAllowed(false);
		

		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(458, 95, 88, 25);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(309, 220, 181, 24);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB", "AB+", "AB-", "O", "O+", "O-"}));
		contentPane.add(comboBox_3);
		comboBox_3.setVisible(false);
		
		btnNewButton.addActionListener(e->
		{
			scrollPane.setVisible(true);
			int i = comboBox.getSelectedIndex();
			int j = comboBox_1.getSelectedIndex();
			if(i!=-1 && j!=-1)
			{
				
			
				String districtString = comboBox_1.getSelectedItem().toString(); 
				String group = comboBox.getSelectedItem().toString(); 
				ResultSet rSet  = dbcon.get_details(group, districtString);
				if(rSet!=null)
				{
					try {
						model.getDataVector().removeAllElements();
						int k=1;
						while(rSet.next())
						{
							model.addRow(new String[] {
									String.valueOf(k) ,
									rSet.getString("name"),
									rSet.getString("blood_group"),
									rSet.getString("phone_no")		
							});
							k++;
						}
						model.fireTableDataChanged();
					} catch (SQLException e1) {}
				}
			}
			
			
			
		});

		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setBounds(458, 301, 88, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(E->{
			String name=textField.getText();
			String username=textField_3.getText();
			String password=passwordField.getText();
			String blood_group=comboBox_3.getSelectedItem().toString();
			String district=comboBox.getSelectedItem().toString();
			String phone=textField_1.getText();
			System.out.println("~~~~~");
			if (!(name.length()==0||
					username.length()==0||
					password.length()==0||
					phone.length()==0||
                    district.length()==0||
                    blood_group.length()==0)) {
			
				int status=dbcon.add(district, blood_group, name, phone, password, username);
				
				switch(status)
				
				{
				case dbcon.ERROR:
					JOptionPane.showMessageDialog(null, "ERROR DETECTED");
					break;
				case dbcon.FAILED:
					JOptionPane.showMessageDialog(null, "Failed");
					break;
				case dbcon.PRIMARY_KEY:
						JOptionPane.showMessageDialog(null, "User already exist");
						break;
				case dbcon.SUCCESS:
					JOptionPane.showMessageDialog(null, "sucess");
					break;
				
			
			}
			}
		});
		
		
		Label label_2 = new Label(" NAME :");
		label_2.setBounds(173, 125, 68, 21);
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_2);
		label_2.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(309, 127, 181, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		Label label_3 = new Label("DISTRICT :");
		label_3.setBounds(173, 173, 92, 21);
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_3);
		label_3.setVisible(false);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(309, 173, 181, 24);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ALAPPUZHA", "ERNAKULAM", "IDUKKI", "KANNUR", "KASARAGOD", "KOLLLAM", "KOTTAYAM", "KOZHIKODE", "MALAPPURAM", "PALAKKAD", "PATHANAMTHITTA", "THIRUVANANTHAPURA", "THRISSUR", "WAYANAD"}));
		contentPane.add(comboBox_2);
		comboBox_2.setVisible(false);
		
		Label label_4 = new Label("BLOOD GROUP :");
		label_4.setBounds(173, 223, 111, 21);
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_4);
		label_4.setVisible(false);
		
		
				Label label_5 = new Label("PHONE NO :");
		label_5.setBounds(173, 268, 92, 21);
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(label_5);
		label_5.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 270, 181, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JButton btnNewButton_1_1 = new JButton("b");
		btnNewButton_1_1.setBounds(769, 15, 51, 55);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.setVisible(false);
		btnNewButton_1_1.addActionListener(e->{
			
			 this.dispose();
			 new adminentry();
			 
			
			});
		
		JButton btnNewButton_4 = new JButton("b");
		btnNewButton_4.setBounds(769, 15, 51, 51);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(e->{
			
			 this.dispose();
			 new frames();
			 
			
			});
		
		
		
		panel.setBounds(24, 26, 139, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_6 = new Label("Age :");
		label_6.setFont(new Font("Dialog", Font.BOLD, 12));
		label_6.setBounds(580, 125, 68, 21);
		contentPane.add(label_6);
		label_6.setVisible(false);
		
		
		Label label_7 = new Label("Weight :");
		label_7.setBounds(580, 173, 68, 21);
		contentPane.add(label_7);
		label_7.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(669, 125, 187, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2 .setVisible(false);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(669, 173, 187, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3 .setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label.setVisible(true);
				label_1.setVisible(true);
				comboBox.setVisible(true);
				comboBox_1.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton_2.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_1_1.setVisible(true);
				panel.setVisible(false);
				label_6.setVisible(false);
				label_7.setVisible(false);
				textField_3 .setVisible(false);
				textField_2 .setVisible(false);
			}
		});
		btnNewButton_2.setBounds(12, 44, 104, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			label_2.setVisible(true);
			label_3.setVisible(true);
			label_4.setVisible(true);
			label_5.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			comboBox_2.setVisible(true); 
			comboBox_3.setVisible(true);
			btnNewButton_2.setVisible(false);
			btnNewButton_1.setVisible(true);
			panel.setVisible(false);
			btnNewButton_4.setVisible(false);
			btnNewButton_1_1.setVisible(true);
			label_6.setVisible(true);
			label_7.setVisible(true);
			textField_2 .setVisible(true);
			textField_3 .setVisible(true);
			label_8.setVisible(true);
			label_9.setVisible(true);
			textField_4.setVisible(true);
			passwordField.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(12, 99, 104, 25);
		panel.add(btnNewButton_3);
		
	
		
		
		
		
		setVisible(true);
	}
}
