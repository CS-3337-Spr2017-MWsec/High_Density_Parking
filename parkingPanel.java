
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class parkingPanel extends JPanel
{
	private Tile[][] grid;
	// position values for drawing items
	int gridXstart = 598;
	int gridYstart = 33;
	int gridBuffer = 3;
	int tileSize = 40;
	// positions for placing buttons
	Location buttonDrop = new Location(200,500);
	Location buttonRetrieve = new Location(240,500);
	// the buttons we will be using
	JButton drop = new JButton("Drop");
	JButton retrieve = new JButton("Retrieve");
	
	// color assignments
	private Color unknownColor = Color.red;
	private Color emptyColor = Color.black;
	private Color noCar = Color.gray;
	private Color oneColor = new Color(0,255,0); // brightest green
	private Color twoColor = new Color(0,200,0);
	private Color threeColor = new Color(0,150,0);
	private Color fourColor = new Color(0,100,0);// darkest green being used
	
	// Instantiate a parkingPanel with a 2-D array matrix
	public parkingPanel(Tile[][] a)
	{
		// set grid equal to the given 2-D array
		grid = a;
		fillRandomly();
		this.setBounds(598, 33, 200, 400);
		// the paintComponent aspect will take care of the rest.	
	}
	public parkingPanel()
	{
		
	}
	public void fillRandomly()
	{
		for(int x =0; x < 8; x++ )
		{
			for(int y=0; y<8; y++)
			{
				int ran = (int) (Math.random()*5);
				Tile t = new Tile(x,y,0,ran);
				grid[x][y] = t;
			}
		}
		int ranX = (int) (Math.random()*5);
		int ranY = (int) (Math.random()*5);
		grid[ranX][ranY].setTime(-1);
	}
	// This is where everything will be drawn (This is ran automatically )
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);// call the super to handle the base aspects of paintComponent
		this.setBackground(Color.WHITE);
		
		// Lets paint the grid
		paintGrid(g);
	}
	
	public Location positionToPixels(int x, int y)
	{
		int pixelX = (gridXstart + (tileSize + gridBuffer)*x);
		int pixelY = (gridYstart + (tileSize + gridBuffer)*y);
		Location l = new Location( pixelX, pixelY);
		
		return l;
	}
	
	
	public void paintGrid(Graphics g)// call to print the grid;
	{
		g.setColor(Color.black);// Set the color of the background of the 
		g.fillRect(gridXstart-gridBuffer, gridYstart-gridBuffer, grid.length*(tileSize+gridBuffer)+gridBuffer, grid.length*(tileSize+gridBuffer)+gridBuffer);// draw the background  
		
		
		
		for(int x =0; x< grid.length; x++)
		{
			for(int y =0; y< grid.length; y++)
			{
				g.setColor(  getColor(x,y) );// set the color to the current tile.
				Location l = positionToPixels(x,y);
				g.fillRect(l.getX(), l.getY(), tileSize, tileSize);
			}
		}
		
	}
	public Color getColor(int x, int y)
	{
		Color r = noCar;
		Tile t = grid[x][y];
		if(t.getTime() == Tile.EMPTY)
		{
			return Color.black;
		}
		if(t.getTime() == Tile.ONE)
		{
			return oneColor;
		}
		else if(t.getTime() == Tile.TWO)
		{
			return twoColor;
		}
		else if(t.getTime() == Tile.THREE)
		{
			return threeColor;
		}
		else if(t.getTime() == Tile.FOUR)
		{
			return fourColor;
		}
		return r;
	}
}

