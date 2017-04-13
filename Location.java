
public class Location 
{
private int x,y;

// empty Constructor
public Location()
{
	
}
// base line Constructor
public Location( int x, int y)
{
	this.x = x;
	this.y = y;
}

// baseline Getter's and Setters
public int getX()
{
	return x;
}
public int getY()
{
	return y;
}
public void setX(int e)
{
	y = e;
}
public void setY(int e)
{
	x = e;
}

public boolean equals(Location c)
{
	if( this.x == c.x && this .y == c.y)
	{
		return true;
	}
	return false;
}
// basic move functions.. the boundary of which will be determined by PARKINGGRID
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

public String toString()
{
	return "("+x+","+y+")";
}
}
