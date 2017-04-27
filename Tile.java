
public class Tile 
{
// The amount of TIME car will be present for, represented as integers
public static final int ONE =1, TWO = 2,  THREE =3,FOUR =4;
public static final int EMPTY = -1;
public static final int NOTIME = -2;


Location position;
private int ID;// if -1 the tile is EMPTY!
private int time; // -1 if there is no time.

private boolean DNE = false;

public Tile()
{
	
}
public Tile( int x, int y, int ID, int time)//constructor for Tile.
{
	position = new Location(x,y);
	this.ID = ID;
	this.time = time;
	
	// testing
}

public int getX()
{
	return position.getX();
}
public int getY()
{
	return position.getY();
}
//getters and setters for time.
public int getTime()
{
	return this.time;
}
public void setTime(int time) 
{
	this.time = time;
}





}
