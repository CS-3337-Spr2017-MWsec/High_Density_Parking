import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.util.TimerTask;
// This will be the "Main" Class.

// Will hold the Grid, and will use the panel to PAINT accordingly
public class AutomatedParkingLot extends JFrame
{	
	// ******************************************** MISC stff **************************************************
		static int time = 250; // can have a value range of 0 -> 2399
	//********************************High Level Stuff we Need************************************************
	public static parkingGrid pGrid = new parkingGrid(8);
	public static JFrame GUI = new JFrame("High Density Parking Structure");
	
	public static Tile tempTile = new Tile();
	public static int tempID = 0;
	//********************************************Button Stuff*************************************************
	
	public static JButton drop = new JButton("Drop Off"); public static int dx = 80,  dy = 485;
	public static JButton retrieve = new JButton("Retrieve"); public static int rx = dx+200,  ry = dy;
	public static JButton dropSubmit = new JButton("Submit");
	public static JButton retrieveSubmit = new JButton("Submit");
	public static JButton one = new JButton("One Hour");  
	public static JButton two = new JButton("Two Hours");
	public static JButton three = new JButton("Three Hours");
	public static JButton unknown = new JButton("Unknown");
	// ******************************************** Card Swipe Stuff *******************************************
	static JLabel swipeCard = new JLabel ("Please swipe your card");
	static JLabel selectTime = new JLabel ("How long would you like to stay?");
	static JTextField input = new JTextField();
	
	//********************************************Panel Stuff***************************************************
	public static parkingPanel gridPanel; static int gx = 0, gy = 0;
	
	
	// **********************************Algorithm Stuff needed*************************************************
	static ArrayList<Location> moves = new ArrayList<Location>();// this will hold the steps that need to be taken
	static ArrayList<Location> Emptymoves = new ArrayList<Location>();// if there isn't an empty location at 3,7 then place one
	static ArrayList<Location> que = new ArrayList<Location>(); // this will be the list of ID's needed to be processed
	static ArrayList<Location> removeque = new ArrayList<Location>();
	
	// ********************************** Boolean Gates Needed *************************************************
	public static boolean DropMode = false;
	public static boolean RetrieveMode = false;
	public static boolean ReceiptMode = false;
	public static boolean StartMode = true;
	
	public static int ReceiptTime =0;
	
	// Location of the starting point for either Drop off or Retrieve... doesn't matter which.
	public static Location Start = new Location(3,7);
	public static boolean swap = true;
	// **********************************Labels for Cosmetics **************************************************
	public static String sideMessage1 = " Welcome to Java Parking",
	sideMessage2 = "Number of Unfilled Spots = "+pGrid.numberOfUnfilled(),
	sideMessage3 = " Car's in Que to be Removed = "+removeque.size(),
	sideMessage4 = " Current Time is "+time/100+":"+(time%100)/10+(time%10);
	public static JLabel sideMessageLabel1 = new JLabel(sideMessage1);
	public static JLabel sideMessageLabel2 = new JLabel(sideMessage2);
	
	public static JLabel sideMessageLabel4 = new JLabel(sideMessage4);
	
	public static String receiptMessage1 = "Reciept",
	receiptMessage2 = "Your total today was ",
	receiptMessage3 = "For the time of ",
	receiptMessage4 = "Card used : ";
	public static JLabel receiptMessageLabel1 = new JLabel();
	public static JLabel receiptMessageLabel2 = new JLabel();
	public static JLabel receiptMessageLabel3 = new JLabel();
	public static JLabel receiptMessageLabel4 = new JLabel();
	//**********************************************************************************************************
	
	
	public static void main(String[] args)
	{
		tempTile = new Tile(3,7,tempID,0);// This is tile that will be dynamically added to.
		pGrid.fillSystem(); gridPanel = new parkingPanel(pGrid.grid);
		GUI.setLayout(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add Panels
		addPanels();
		// Add Cosmetics
		
		// Initialize all aspects
		InitializeButtons();
		InitializeLabels();
		InitializeTextFields();
		// Add Initial Buttons
		addButtons();
		// add Timer Events
		
		
		//add Event Listeners
		addEventListeners();
		
		// Add Timer Events / Schedules
		addTimerEvents();
		
		// Add the initial ride side visual
		addInitialRightSide();
		
		//Basic JFRAME starting operation set the size, and make it visible
		GUI.setSize(850,600);
		GUI.setVisible(true);	
	}
	
	public static void addRetrievalStuff()
	{
		addSwipeCardInput();
	
	}
	public static ArrayList<Location> movesStart()
	{
		ArrayList<Location> ret = new ArrayList<Location>();
		
		ret = pGrid.sortingMoves();
		
		return ret;
	}
	public static void addPanels()
	{
		gridPanel.setBounds(gx,gy,500,475); // Sets the bounds and location of the GRIDPANEL//
		GUI.add(gridPanel);
	}
	public static void InitializeButtons()
	{
				int butSX = 140// Button Size X
				,butSY = 60// Button Size Y
				,SBX = 600 // Side Button X start location
				,SBY = 200 // Side Button y start location
				,SBSX = 130 // Side Button X Size
				,SBSY = 50; // Side Button Y Size
				
		one.setBounds(SBX, SBY, SBSX, SBSY);
		two.setBounds(SBX, SBY+(1*SBSY), SBSX, SBSY);
		three.setBounds(SBX, SBY+(2*SBSY), SBSX, SBSY);
		unknown.setBounds(SBX, SBY+(3*SBSY), SBSX, SBSY);
		
		dropSubmit.setBounds(SBX, SBY+(4*SBSY)+ 35, SBSX, SBSY);
		retrieveSubmit.setBounds(SBX, SBY-100, SBSX, SBSY);
		
		retrieve.setBounds(rx, ry, butSX, butSY);
		drop.setBounds(dx,dy, butSX, butSY);
		
		makeButtonsWhite();
	}
	public static void makeButtonsWhite()
	{
		one.setBackground(Color.WHITE);
		two.setBackground(Color.WHITE);
		three.setBackground(Color.WHITE);
		unknown.setBackground(Color.WHITE);
		dropSubmit.setBackground(Color.WHITE);
		retrieveSubmit.setBackground(Color.WHITE);
		drop.setBackground(Color.WHITE);
		retrieve.setBackground(Color.WHITE);
	}
	public static void InitializeLabels()
	{
		int SBX = 600, SBY = 200;
		swipeCard.setBounds(600, 0, 150, 50);
		selectTime.setBounds(SBX-30,SBY-50 , 200, 50);
		
		// initial side stuff
		int lX = 600;
		int lDy = 50; // difference in y locations
		int sx = 175;
		sideMessageLabel1.setBounds(530,sx,400,lDy);
		sideMessageLabel2.setBounds(510,sx+1*lDy,400,lDy);
		
		sideMessageLabel4.setBounds(555,sx+2*lDy,400,lDy);
		
		sideMessageLabel1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		sideMessageLabel1.setForeground(Color.MAGENTA);
		sideMessageLabel2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		sideMessageLabel2.setForeground(new Color(0,80,0));
		
		sideMessageLabel4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		sideMessageLabel4.setForeground(Color.BLUE);
		
		int rx = 500;
		int ry = 0;
		receiptMessageLabel1.setBounds(rx+135,ry+(80*0),300,80);
		receiptMessageLabel1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		receiptMessageLabel2.setBounds(rx+40,ry+(80*1),300,80);
		receiptMessageLabel2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		receiptMessageLabel3.setBounds(rx+80,ry+(80*2),300,80);
		receiptMessageLabel3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		receiptMessageLabel4.setBounds(rx+75,ry+(80*3),300,80);
		receiptMessageLabel4.setFont(new Font("Tahoma", Font.PLAIN, 22));
	}
	public static void addRightSideReceipt()
	{
		clearRightSide();
		GUI.add(receiptMessageLabel1);
		GUI.add(receiptMessageLabel2);
		GUI.add(receiptMessageLabel3);
		GUI.add(receiptMessageLabel4);
	}
	public static void InitializeTextFields()
	{
		input.setBounds(565,50,200,40);
	}
	public static void addInitialRightSide()
	{
		GUI.add(sideMessageLabel1);
		GUI.add(sideMessageLabel2);
		
		GUI.add(sideMessageLabel4);
	}
	public static void updateInitialRightSide()
	{
		
				sideMessageLabel1.setText("Welcome to Java Parking");
				sideMessageLabel2.setText("Number of Spots Unfilled = "+pGrid.numberOfUnfilled());
				
				sideMessageLabel4.setText("Current Time is "+time/100+":"+(time%100)/10+(time%10));
				
	}
	public static void addButtons()
	{
		GUI.add(drop);
		GUI.add(retrieve);
	}
	public static void addDropButtons()
	{
		GUI.add(selectTime);
		GUI.add(one);
		GUI.add(two);
		GUI.add(three);
		GUI.add(unknown);
		GUI.add(dropSubmit);
	}
	public static void addRetrieveButtons()
	{
		GUI.add(retrieveSubmit);
	}
	public static void addSwipeCardInput()
	{
		GUI.add(swipeCard);
		GUI.add(input);
	}
	public static void addRightSideDrop()
	{
		addDropButtons();
		addSwipeCardInput();
	}
	public static void addRightSideRetrieve()
	{
		addRetrieveButtons();
		addSwipeCardInput();
	}
	public static void clearRightSide()//
	{
		//btns
		GUI.remove(one);
		GUI.remove(two);
		GUI.remove(three);
		GUI.remove(unknown);
		GUI.remove(dropSubmit);
		GUI.remove(retrieveSubmit);
		//lables
		GUI.remove(swipeCard);
		GUI.remove(selectTime);
		GUI.remove(sideMessageLabel1);
		GUI.remove(sideMessageLabel2);
		GUI.remove(sideMessageLabel4);
		GUI.remove(receiptMessageLabel1);
		GUI.remove(receiptMessageLabel2);
		GUI.remove(receiptMessageLabel3);
		GUI.remove(receiptMessageLabel4);
		//txtF
		GUI.remove(input);
		//clear input text
		input.setText("");
	}
	
	
	public static void addEventListeners()
	{
		drop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// If Drop is clicked pop up the buttons on the right side
				// for the user to submit CARD info and fully submit there car
				
				//FIRST CLEAR RIGHT SIDE
				clearRightSide();
				// Then Add Right Side Drop Material
				addRightSideDrop();
				
			}	
		});
		// (NOT DONE)
		retrieve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Clear the right Side
				clearRightSide();
				addRightSideRetrieve();
			}	
		});
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// if the "One" Button is clicked set temp's time to 1... similar for the others 2,3
				// clear the color of other buttons
				clearDropButtonColor();
				// redraw buttons
				GUI.repaint();
				// set background color to green
				one.setBackground(Color.green);
				// set the time 
				tempTile.setTime(1);
			}	
		});
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// clear the color of other buttons
				clearDropButtonColor();
				// redraw buttons
				GUI.repaint();
				// set background color to green
				two.setBackground(Color.green);
				// set the time 
				tempTile.setTime(2);
			}	
		});
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// clear the color of other buttons
				clearDropButtonColor();
				// redraw buttons
				GUI.repaint();
				// set background color to green
				three.setBackground(Color.green);
				// set the time 
				tempTile.setTime(3);
			}	
		});
		unknown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// clear the color of other buttons
				clearDropButtonColor();
				// redraw buttons
				GUI.repaint();
				// set background color to green
				unknown.setBackground(Color.green);
				// set the time 
				tempTile.setTime(Tile.UKNOWN);
			}	
		});
		dropSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				makeButtonsWhite();// so next time the buttons are all white
				moves = new ArrayList<Location>();// clear out moves
				String Card1 = input.getText();
				String ccNumber = "";
				String custName = "";
				if(Card1.length() > 3)
				{
					String raw = "{%B<acct_no>^<cust_name>^<*>?}";
					raw = Card1;
					int head = raw.indexOf("%B");
					int middle = raw.indexOf("^");
					int tail = raw.lastIndexOf("^");
	
					ccNumber = raw.substring(head+2, middle); 
					custName = raw.substring(middle+1, tail);
				}
			input.setText("");
			if(ccNumber.length() > 1)
			{
				tempTile.id = ccNumber; // WE WILL COMPARE STRINGS! with .equals to match.
			}
			tempTile.timeStamp = time;
			// submit by setting the Tile at (7,4) equal to a new Tile TEMP 
			pGrid.grid[3][7] = tempTile;
			// ADD that Tile from the location to the QUE
			que.add(new Location(3,7));
			// Set tempTile to be a new tempTile
			tempTile = new Tile(3,7,tempID,0);
			clearRightSide();
			addInitialRightSide();
			
			moves = pGrid.FullPath(new Location(3,7),pGrid.placementSpot(new Location(3,7)));
			DropMode = true;
			GUI.repaint();
			}	
		});
		retrieveSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				String Card1 = input.getText();
				String ccNumber = "";
				String custName = "";
				if(Card1.length() > 3)
				{
					String raw = "{%B<acct_no>^<cust_name>^<*>?}";
					raw = Card1;
					int head = raw.indexOf("%B");
					int middle = raw.indexOf("^");
					int tail = raw.lastIndexOf("^");
	
					ccNumber = raw.substring(head+2, middle); 
					custName = raw.substring(middle+1, tail);
				}
			input.setText("");
			if(ccNumber.length() > 1)
			{
			    Location remove = pGrid.markTile(ccNumber);// Mark the Tile and returns the Location
			    if(remove.getX() > 0)
			    {
			    	RetrieveMode = true;
				    moves = pGrid.FullPath(remove, new Location(4,7));
				    int timestamped = pGrid.grid[remove.getX()][remove.getY()].timeStamp;
				    int v1 = (time/100)*60+(time%100);
				    int v2 = ((timestamped/100)*60)+(timestamped%100);
				    int minutes = v1 - v2;
				    
				    int cost = minutes/4;
				    
				    receiptMessageLabel1.setText(receiptMessage1);
				    receiptMessageLabel2.setText(receiptMessage2+"$"+cost+".00");
				    receiptMessageLabel3.setText(receiptMessage3+" "+minutes/60+":"+(minutes%60)/10+""+(minutes%10));
				    receiptMessageLabel4.setText(receiptMessage4+"XX"+ccNumber.substring(ccNumber.length()-4, ccNumber.length()));
				    ReceiptMode = true;	
				    clearRightSide();
					addRightSideReceipt();
			    }
			    else
			    {
			    	clearRightSide();
			    	addInitialRightSide();
			    }
			}
			
			
			
			GUI.repaint();
			}	
		});
	}
	public static void clearDropButtonColor()
	{
		one.setBackground(Color.white);
		two.setBackground(Color.white);
		three.setBackground(Color.white);
		unknown.setBackground(Color.white);
	}
	public static void consoleOutput()
	{
		for(int y=0; y< 8; y++)
		{
			for(int x=0; x<8;x++)
			{
				System.out.print(pGrid.grid[x][y].getTime()+" ");
			}
			System.out.println("");
		}
	}
	public static void addTime(int t)
	{
		time += t;
		if(time > 2399)
		{
			time -= 2399;
		}
		if(time%100 >= 60)
		{
			time -= 60;
			time += 100;
		}
	}
	public static void addTimerEvents()
	{
		// Random View Timer
		consoleOutput();
		
		Timer God = new Timer ();
		God.schedule(new TimerTask(){
			@Override
			public void run()// randomly set pGrid
			{
				addTime(1);
				if(ReceiptMode == true)
				{
					ReceiptTime++;
					if(ReceiptTime >= 12)
					{
						ReceiptMode = false;
						ReceiptTime = 0;
						clearRightSide();
						addInitialRightSide();
					}
				}
			}		
		}, 1,1000);
		
		Timer Timer = new Timer ();
		Timer.schedule(new TimerTask(){
			@Override
			public void run()// consistently update the grid every 300ms
			{	
			if(DropMode == true)
			{
				if(moves.size()>0)
				{
					pGrid.swap(moves.get(0));
					moves.remove(0);
				}
				else
				{
					DropMode = false;
					StartMode = true;
				}
			}
			else if(RetrieveMode == true)
			{
				if(moves.size()>0)
				{
					pGrid.swap(moves.get(0));
					moves.remove(0);
				}
				else
				{
					Tile n = new Tile(4,7,0,Tile.NOTFILLED);
					pGrid.grid[4][7]=n;
					RetrieveMode = false;
					StartMode = true;
				}
			}
			
			else if(StartMode == true)
			{
				if(pGrid.grid[3][7].getTime() != Tile.NOTFILLED)
				{
					Location nfilled = pGrid.firstNotFilled();
				}
				else if( Emptymoves.size() > 0)
				{
					pGrid.swap(Emptymoves.get(0));
					Emptymoves.remove(0);
				}
				else if(moves.size() > 0)//if we got steps to move... then move
				{
					pGrid.swap(moves.get(0));
					moves.remove(0);
				}
				else
				{
					moves = movesStart();
				}
			}
			
			updateInitialRightSide();
			gridPanel.grid =  pGrid.grid;
			gridPanel.repaint();
			GUI.repaint();
			if(moves.size() > 0)
			{
				Location end = moves.get(moves.size()-1);
				Location test = pGrid.placementSpot(new Location( 0,0) );
			}
			
			}		
		}, 300,500);
		
		
	}
}






