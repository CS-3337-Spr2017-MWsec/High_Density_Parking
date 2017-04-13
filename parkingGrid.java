import java.util.ArrayList;

public class parkingGrid // the grid of parking
{
private int numberOfCars =0; // initialize it to zero.
private static int gridSize; // size of n of the NxN grid

Tile[] list = new Tile[64];// holds an array of 64 tiles, to be used to search the list of cars.
Tile[][] grid; // grid of tiles to manipulate

Tile emptySpace = new Tile(3,7,Tile.EMPTY,Tile.NOTIME);

// constructor.
public parkingGrid(int gSize)
{
	initGrid(gSize);
}

public void addCarToList(int ID)// add car to the array of Tiles in correct position
{
	// place a not filled tile at the entrance
	
	
	// fill the tile with the appropriate ID, Estimate time of departure
	
	
	//create a movement path for the tile.
	numberOfCars++;
}
public Tile returnCarTile(int ID)// will use a binarySearch to go through the sorted list of tiles and return the tile needed
{
	Tile r = new Tile();// empty tile that will be later assigned and returned.
	// given the ID, search through the regular arraylist of filled tiles for the position of the car needed
	
	
	//once you have found the appropriate tile, allow r to be equal to that tile
	return r;
}
public void swap(Tile a, Tile b)// will be used to swap an empty space with an actual tile
{

		// (1) set GRID[a.x][a.y] = GRID[b.x][b.y] , to cover possible passes by VALUE and not reference
		// this makes where A was in the grid equal to B
		// and then it makes B = to A
	grid[a.getX()][a.getY()] = b;
	grid[b.getX()][b.getY()] = a;
		//(2) now switch their position values
	grid[a.getX()][a.getY()].position = b.position;
	grid[b.getX()][b.getY()].position = a.position;
		
	// Then swap their locations.
}
private void initGrid(int gSize)// creates a grid of "EMPTY"/"No Car" tiles.
{
	grid = new Tile[gSize][gSize];
	for(int x =0; x < gSize; x++)
	{
		for(int y =0; y< gSize; y++)
		{
			grid[x][y] = new Tile(x,y,Tile.EMPTY,Tile.NOTIME);// create a Tile at (X,Y) that is void of Car, and Time Slot (EMPTY TILE)
		}
	}
}

// tested and working ( EPath , 
public ArrayList<Location> EPath(Location current, Location desired)
{
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
	}
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
	}
	
	return r;
}
public ArrayList<Location> HPath(Location current, Location desired, Location blocked)
{
	/* Notes
	HPath 1.1
	As of 4/6/2017 HPath works accordingly up to the functions of EPath, But Epath will still be used when there is
	no such need to check for blocked locations, and thus increasing effeciency with a reduction of comparisons
	
	HPath 1.2
	
	*/
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{// if E path cannot handle, Lets make H Path magic
				// x will be the value of the current X that were traversing at.
				
				}
				else
				{
				r.add(temp);
				}
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{// if E path cannot handle, Lets make H Path magic
					
				}
				else
				{
				r.add(temp);
				}
			}
			cx = dx;
		}
	}
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{// if E path cannot handle, Lets make H Path magic
					
				}
				else
				{
				r.add(temp);
				}
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{// if E path cannot handle, Lets make H Path magic
					
				}
				else
				{
				r.add(temp);
				}
			}
			
			cy = dy;
		}
	}
	return r;
}


public ArrayList<Location> Clockwise(Location current, Location desired, Location blocked)
{
	ArrayList<Location> r = new ArrayList<Location>();
	// desired is above
	
	// desired is below
	
	// desired is right
	
	// desired is left
	return r;
}
public ArrayList<Location> CClockwise(Location current, Location desired, Location blocked)
{
	ArrayList<Location> r = new ArrayList<Location>();
		// desired is above
	
		// desired is below
		
		// desired is right
		
		// desired is left		
	return r;
}

}// end class
