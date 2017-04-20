import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import java.awt.List;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Label;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Parking_Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parking_Gui frame = new Parking_Gui();
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
	
	
	public Parking_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 746);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		// Second Panel for the Tiles Moving----------------------------------------------------------------------------------------- 
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(598, 33, 450, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblxThingsHere = new JLabel("8X8 THINGS HERE");
		lblxThingsHere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblxThingsHere.setBounds(132, 301, 252, 16);
		panel_1.add(lblxThingsHere);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(26, 33, 427, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to High-Density");
		lblNewLabel.setBounds(58, 23, 254, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JLabel lblParking = new JLabel("Parking");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblParking.setBounds(153, 78, 87, 25);
		panel.add(lblParking);
		
		
		
		
		
		
		//DropOFF Semi Working 
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		JPanel Dpanel = new JPanel();
		Dpanel.setBackground(SystemColor.menu);
		Dpanel.setBounds(26, 33, 427, 641);
		Dpanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Retrieve");
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				contentPane.remove(panel);
				contentPane.add(Dpanel);
				contentPane.revalidate();
				contentPane.repaint();
				
				
				JLabel lblNewLabel = new JLabel("High-Density Parking System");
				lblNewLabel.setBounds(58, 23, 350, 50);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
				Dpanel.add(lblNewLabel);
				
				JLabel lblReceipt = new JLabel ("Please swipe your card");
				Dpanel.add(lblReceipt);
				lblReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblReceipt.setBounds(90, 150, 254, 25);
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(58, 531, 109, 50);
		panel.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		JPanel Rpanel = new JPanel ();
		Rpanel.setBackground(SystemColor.menu);
		Rpanel.setBounds(26, 33, 427, 641);
		Rpanel.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("DropOff");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				contentPane.remove(panel);
				contentPane.add(Rpanel);
				contentPane.revalidate();
				contentPane.repaint();
				
				
				JLabel lblNewLabel = new JLabel(" High-Density Parking System ");
				lblNewLabel.setBounds(58, 23, 350, 50);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
				Rpanel.add(lblNewLabel);
				
				
				JLabel lblReceipt = new JLabel ("Please swipe your card");
				Rpanel.add(lblReceipt);
				lblReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblReceipt.setBounds(90, 150, 254, 25);
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(281, 530, 109, 50);
		panel.add(btnNewButton_1);
		
		
	}
}
