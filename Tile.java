
public class Tile 
{
// The amount of TIME car will be present for, represented as integers
public static final int UNKNOWN =0,HALF = 1,ONE =2, ONE_HALF =3, TWO = 4, TWO_HALF =5, THREE =6, THREE_HALF =7,FOUR =8;
public static final int EMPTY = -1;
public static final int NOTIME = -1;


private int x;// X location of the Tile
private int y;// Y location of the Tile
private int ID;// if -1 the tile is EMPTY!
private int time; // -1 if there is no time.

public Tile()// empty constructor
{
	
} 
public Tile( int x, int y, int ID, int time)//constructor for Tile.
{
	this.x = x;
	this.y = y;
	this.ID = ID;
	this.time = time;
	
	// testing
}

//Movement Methods. To be called by parkingGrid
public void moveUP()
{
 y--;	
}
public void moveRight()
{
 x++;	
}
public void moveDown()
{
 y++;	
}
public void moveLeft()
{
 x--;	
}

//getters and setters for time.
public int getTime()
{
	return time;
}
public void setTime(int time) 
{
	this.time = time;
}





}
