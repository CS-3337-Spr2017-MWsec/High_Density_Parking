import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

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
		setBounds(100, 100, 823, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 363, 578);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDrop = new JButton("Drop");
		btnDrop.setBounds(24, 514, 97, 25);
		panel.add(btnDrop);
		
		JButton btnRetrive = new JButton("Retrive");
		btnRetrive.setBounds(217, 514, 97, 25);
		panel.add(btnRetrive);
		
		JLabel lblWelcomeToDynamic = new JLabel("Welcome to Dynamic Parking");
		lblWelcomeToDynamic.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWelcomeToDynamic.setBounds(57, 27, 257, 25);
		panel.add(lblWelcomeToDynamic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(423, 13, 370, 578);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblxThingsHere = new JLabel("8X8 THINGS HERE");
		lblxThingsHere.setBounds(133, 76, 147, 16);
		panel_1.add(lblxThingsHere);
	}
}
