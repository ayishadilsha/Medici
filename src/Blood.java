import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Blood {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("MEDICI-2022");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setResizable(true); 
		
		JLabel label = new JLabel("HELP SAVE LIVES DONATE BLOOD");
		frame.add(label);
	    label.setBounds(140, 20, 400, 80);
	    label.setForeground(Color.RED);
	    label.setFont(new Font("SansSherif", Font.BOLD, 20));
	    
	    JLabel label1 = new JLabel();
	    label1.setIcon(new ImageIcon("/home/user/eclipse-workspace/MEDICI/medici.png"));
		frame.add(label1, BorderLayout.NORTH);
		label1.setBounds(200, 100, 400, 240);
	
		JButton button = new JButton("sign in");
		button.setBounds(100, 350, 100, 40);
	    frame.add(button);
	    
	    
	    
	  
	    
	}

}
