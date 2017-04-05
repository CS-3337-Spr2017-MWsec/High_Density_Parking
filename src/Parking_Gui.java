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
		setBounds(100, 100, 1006, 746);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// First Panel for the Welcoming and the scanning -------------------------------------------------------------------
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(26, 33, 426, 641);
		contentPane.add(panel);
		panel.setLayout(null);
	
		
		// Drop off Button ---------------------------------------------------------------------------------------------------
		JButton btnDrop = new JButton("Drop");
		btnDrop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDrop.setBackground(Color.WHITE);
		btnDrop.setBounds(25, 566, 108, 44);
		panel.add(btnDrop);
		
		
		
		
		//Pick up button -------------------------------------------------------------------------------------------------------
		JButton btnRetrive = new JButton("Retrieve");
		btnRetrive.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRetrive.setBackground(Color.WHITE);
		btnRetrive.setBounds(273, 566, 115, 44);
		panel.add(btnRetrive);
		
		
		
		// Labels for the welcoming screen --------------------------------------------------------------------------------------
		
		JLabel lblWelcomeToDynamic = new JLabel("Welcome to High Density ");
		lblWelcomeToDynamic.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcomeToDynamic.setBounds(46, 40, 342, 102);
		panel.add(lblWelcomeToDynamic);
		
		Label label = new Label("Parking ");
		label.setFont(new Font("Dialog", Font.PLAIN, 30));
		label.setBounds(135, 143, 124, 44);
		panel.add(label);
		
		
		
		
		
		
		
		
		// Second Panel for the Tiles Moving----------------------------------------------------------------------------------------- 
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(502, 33, 450, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblxThingsHere = new JLabel("8X8 THINGS HERE");
		lblxThingsHere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblxThingsHere.setBounds(132, 301, 252, 16);
		panel_1.add(lblxThingsHere);
	}
}
