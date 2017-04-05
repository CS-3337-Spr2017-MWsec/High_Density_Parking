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
	
	
	numberOfCars++;
}
public Tile returnCarTile(int ID)// will use a binarySearch to go through the sorted list of tiles and return the tile needed
{
	Tile r = new Tile();
	
	
	return r;
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

}// end class
