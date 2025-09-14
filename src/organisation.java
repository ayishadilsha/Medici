import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

public class organisation extends JFrame {

	private JPanel frameo;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organisation frame = new organisation();
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
	public organisation() {
		setTitle("ORGANISATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 474);
		frameo = new JPanel();
		frameo.setFont(new Font("Dialog", Font.BOLD, 13));
		frameo.setBackground(Color.WHITE);
		frameo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frameo);
		frameo.setLayout(null);
		
		Label label = new Label("Organisation :");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBackground(Color.WHITE);
		label.setBounds(28, 23, 105, 21);
		frameo.add(label);
		
		JLabel label_3 = new JLabel();
		label_3.setBackground(new Color(255, 255, 255));
		label_3.setIcon(new ImageIcon("/home/user/eclipse-workspace/MEDICI/medici.png"));
		frameo.add(label_3, BorderLayout.NORTH);
		label_3.setBounds(467, 36, 216, 247);
		frameo.add(label_3);
		
		Label label_1 = new Label("address :");
		label_1.setBounds(32, 119, 87, 21);
		frameo.add(label_1);
		
		Label label_2 = new Label("USER NAME :");
		label_2.setBounds(28, 262, 116, 21);
		frameo.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(188, 262, 216, 21);
		frameo.add(textField_1);
		textField_1.setColumns(10);
		
		Label label_4 = new Label("PASSWORD :");
		label_4.setBounds(28, 321, 105, 21);
		frameo.add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(UIManager.getColor("Button.background"));
		passwordField.setBounds(188, 323, 216, 19);
		frameo.add(passwordField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(188, 110, 226, 109);
		frameo.add(textArea);
		
		
		JButton btnNewButton = new JButton("register");
		btnNewButton.addActionListener(E->{
			String organisation=textField_2.getText();
			String phone_no=textField.getText();
			String username=textField_1.getText();
			String password=passwordField.getText();
			String address=textArea.getText();
			
			if (!(organisation.length()==0||
					address.length()==0||
					password.length()==0||
					phone_no.length()==0||
                    username.length()==0))
                {
			
				int status=dbcon.register(organisation, password, username, phone_no, address);
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
		btnNewButton.setBounds(415, 378, 117, 25);
		frameo.add(btnNewButton);
	
		
		
		JButton btnNewButton_1_1 = new JButton("b");
		btnNewButton_1_1.setIcon(new ImageIcon("/home/user/Downloads/b457fa6c-1bd2-4b02-b862-25d706d19fd0.png"));
		btnNewButton_1_1.setBounds(684, 7, 51, 51);
		frameo.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(e->{
			
			 this.dispose();
			 new frames();
			 
			});
		
		Label label_5 = new Label("phone_no :");
		label_5.setBounds(32, 77, 87, 21);
		frameo.add(label_5);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setBounds(188, 79, 216, 19);
		frameo.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(188, 23, 211, 19);
		frameo.add(textField_2);
		textField_2.setColumns(10);
		
		
		setVisible(true);
		
	}
}
