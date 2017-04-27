import javax.swing.JButton;
import javax.swing.JFrame;


// This will be the "Main" Class.

// Will hold the Grid, and will use the panel to PAINT accordingly
public class AutomatedParkingLot extends JFrame
{
	public static parkingGrid pGrid = new parkingGrid(8);// create a parking grid of size 8x8;
	
	
	// positions for placing buttons
	public static Location buttonDrop = new Location(200,500);
	public static Location buttonRetrieve = new Location(240,500);
	// the buttons we will be using
	public static JButton drop = new JButton("Drop");
	public static JButton retrieve = new JButton("Retrieve");
		
	
	public static void main(String[] args)
	{
		JFrame GUI = new JFrame("High Density Parking Structure");
		//GUI.setLayout(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parkingPanel gridPanel = new parkingPanel(pGrid.grid);
		
		drop.setLocation(buttonDrop.getX(), buttonDrop.getY());
		retrieve.setLocation(buttonRetrieve.getX(), buttonRetrieve.getY());
		
		drop.setSize(30, 30);
		retrieve.setSize(30, 30);
		//GUI.add(drop);
		//GUI.add(retrieve);
		GUI.add(gridPanel);
		GUI.setSize(850,600);
		GUI.setVisible(true);
	}
}