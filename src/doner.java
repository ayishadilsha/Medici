import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Checkbox;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class doner extends JFrame {

	private JPanel framed;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private	TextField textField_1;
	private	TextField textField_2;
	private	TextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doner frame = new doner();
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
	public doner() {
		setTitle("DONAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 473);
		framed = new JPanel();
		framed.setFont(new Font("Dialog", Font.BOLD, 12));
		framed.setBackground(Color.WHITE);
		framed.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(framed);
		framed.setLayout(null);
		
		Label label = new Label("Name  :");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(39, 33, 118, 23);
		framed.add(label);
		
		textField = new TextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(175, 37, 172, 19);
		framed.add(textField);
		
		Label label_1 = new Label("Phone no  :");
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(39, 84, 92, 21);
		framed.add(label_1);
		
		textField_1 = new TextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(175, 84, 172, 19);
		framed.add(textField_1);
		
		Label label_2 = new Label("District  :");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(39, 133, 68, 23);
		framed.add(label_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ALAPPUZHA", "ERNAKULAM", "IDUKKI", "KANNUR", "KASARAGOD", "KOLLLAM", "KOTTAYAM", "KOZHIKODE", "MALAPPURAM", "PALAKKAD", "PATHANAMTHITTA", "THIRUVANANTHAPURA", "THRISSUR", "WAYANAD"}));
		comboBox.setBounds(175, 133, 172, 23);
		framed.add(comboBox);
		
		Label label_3 = new Label("Blood Group  :");
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(39, 177, 118, 21);
		framed.add(label_3);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBox_1.setBounds(175, 175, 172, 23);
		framed.add(comboBox_1);
		
		Label label_4 = new Label("Weight  :");
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(39, 217, 68, 21);
		framed.add(label_4);
		
		JLabel label_5 = new JLabel();
		label_5.setBackground(new Color(255, 255, 255));
		label_5.setIcon(new ImageIcon("/home/user/eclipse-workspace/MEDICI/medici.png"));
		framed.add(label_5, BorderLayout.NORTH);
		label_5.setBounds(441, 84, 207, 213);
		framed.add(label_5);
		
		Button button = new Button("REGISTER");
		button.addActionListener(E->{
			String name=textField.getText();
			String username=textField_3.getText();
			String password=passwordField.getText();
			String blood_group=comboBox_1.getSelectedItem().toString();
			String district=comboBox.getSelectedItem().toString();
			String phone=textField_1.getText();
			String weight=textField_4.getText();
			String age=textField_2.getText();
			int age1=0,weight1=0;
			try {
				age1=Integer.parseInt(age);
				weight1=Integer.parseInt(weight);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ENTER VALID INFORMATION");

			}if (!(name.length()==0||
					username.length()==0||
					password.length()==0||
					phone.length()==0||
                    age1==0||
                    weight1==0)) {
			    int status1=dbcon.add("Donar", password, username);
			    if (status1==dbcon.SUCCESS) {
					
				
				int status=dbcon.signup(username, password, name, phone, district, blood_group);
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
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(483, 372, 118, 23);
		framed.add(button);
		
		Label label_6 = new Label("Age  :");
		label_6.setFont(new Font("Dialog", Font.BOLD, 13));
		label_6.setBounds(39, 259, 68, 21);
		framed.add(label_6);
		
		textField_2 = new TextField();
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setBounds(175, 261, 172, 19);
		framed.add(textField_2);
		
		Label label_7 = new Label("USER NAME :");
		label_7.setBounds(28, 309, 103, 21);
		framed.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 311, 183, 19);
		framed.add(textField_3);
		textField_3.setColumns(10);
		
		Label label_8 = new Label("PASSWORD :");
		label_8.setBounds(28, 348, 103, 21);
		framed.add(label_8);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 350, 183, 19);
		framed.add(passwordField);
		
		textField_4 = new JTextField();
		textField_4.setBounds(175, 219, 172, 19);
		framed.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("b");
		btnNewButton_1.setBounds(597, 12, 51, 44);
		framed.add(btnNewButton_1);
		setVisible(true);
		btnNewButton_1.addActionListener(e->{
			
			 this.dispose();
			 new frames();
			 
			});

	}
	}


