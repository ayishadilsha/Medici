import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Directsearch extends JFrame {

	private JPanel FRAME;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directsearch frame = new Directsearch();
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
	public Directsearch() {
		setTitle("DATA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 481);
		FRAME = new JPanel();
		FRAME.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FRAME);
		FRAME.setLayout(null);
		
		Label label = new Label("BLOOD GROUP :");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(57, 50, 119, 21);
		FRAME.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB", "AB+", "AB-", "O", "O+", "O-"}));
		comboBox.setBounds(198, 50, 165, 21);
		FRAME.add(comboBox);
		
		Label label_1 = new Label("DISTRICT :");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(65, 115, 84, 21);
		FRAME.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "ALAPPUZHA", "ERNAKULAM", "IDUKKI", "KANNUR", "KASARAGOD", "KOLLLAM", "KOTTAYAM", "KOZHIKODE", "MALAPPURAM", "PALAKKAD", "PATHANAMTHITTA", "THIRUVANANTHAPURA", "THRISSUR", "WAYANAD"}));
		comboBox_1.setBounds(198, 112, 165, 24);
		FRAME.add(comboBox_1);
		


		JButton btnNewButton_1_1 = new JButton("b");
		btnNewButton_1_1.setBounds(708, 12, 51, 44);
		FRAME.add(btnNewButton_1_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 228, 614, 178);
		FRAME.add(scrollPane);
		scrollPane.setVisible(false);
		
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
		
		btnNewButton_1_1.addActionListener(e->{
			
			 this.dispose();
			 new frames();
			 
			});
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(295, 178, 117, 25);
		FRAME.add(btnNewButton);
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
		
		
		setVisible(true);
	}
}


