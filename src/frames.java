import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Component;

public class frames extends JFrame implements ActionListener{

	private JPanel JFrame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frames frame = new frames();
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
	public frames() {
		setTitle("MEDICI");
		setDefaultCloseOperation(frames.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 473);
		JFrame = new JPanel();
		JFrame.setAlignmentX(CENTER_ALIGNMENT);
		JFrame.setAlignmentY(CENTER_ALIGNMENT);
		JFrame.setBackground(Color.WHITE);
		JFrame.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(JFrame);
		JFrame.setLayout(null);
		
		Label label = new Label("\"DONATE BLOOD  DONATE SMILE...\"");
		label.setForeground(new Color(220, 20, 60));
		label.setBackground(Color.WHITE);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(127, 10, 407, 53);
		JFrame.add(label);
		
		 JLabel label1 = new JLabel();
		 label1.setIcon(new ImageIcon("/home/user/eclipse-workspace/MEDICI/medici.png"));
		 JFrame.add(label1, BorderLayout.NORTH);
		 label1.setBounds(12, 71, 193, 231); 
		 
		JComboBox comboBox =  new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-REGISTRATION-", "ADMIN(political organization, hospitals, etc)", "DONAR/RECEIVER(create account)"}));
		comboBox.setBounds(206, 143, 283, 31);
		
		JFrame.add(comboBox);
		 
		Label label_1 = new Label("USER NAME");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(487, 255, 86, 21);
		JFrame.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(581, 283, 155, 19);
		JFrame.add(textField);
		textField.setColumns(10);
		
		Label label_2 = new Label("PASSWORD");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(490, 312, 107, 21);
		JFrame.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(581, 339, 155, 21);
		JFrame.add(passwordField);
		
		Button button = new Button("LOGIN");
		button.addActionListener(e->{
				String usernameString=textField.getText();
				String password=passwordField.getText();
				
				int status=dbcon.login(usernameString,password);
				switch(status)
				{
				case dbcon.ERROR:
					JOptionPane.showMessageDialog(null, "ERROR DETECTED");
					break;
				case dbcon.ADMIN:
					JOptionPane.showMessageDialog(null, "login success");
					this.dispose();
					new adminentry();
					break;
				case dbcon.DONAR_RECIVER:
					JOptionPane.showMessageDialog(null, "login success");
					break;
				case dbcon.FAILED:
					JOptionPane.showMessageDialog(null, "Failed");
					break;
				case dbcon.WRONG_PASSWORD:
					JOptionPane.showMessageDialog(null, "incorrect password");
					break;
				case dbcon.INVALID_USERNAME:
					JOptionPane.showMessageDialog(null, "INVALID USERNAME");
					break;
			
			}
			
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(650, 381, 86, 23);
		JFrame.add(button);
		
		
		JButton btnNewButton = new JButton("OK");

		
		btnNewButton.setBounds(415, 202, 69, 25);
		JFrame.add(btnNewButton);
		btnNewButton.addActionListener(e->{
			
			int i = comboBox.getSelectedIndex();
			if(i==1)
	
			{
				this.dispose();
				new organisation();
				
			}
	
			if(i==2) 
			{
				this.dispose();
				new doner();
			}
			
			
			
		});
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(623, 64, 86, 25);
		JFrame.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e->{
			
		 this.dispose();
		 new Directsearch();
		 
		});
		
		
		setVisible(true);								

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}}

	
