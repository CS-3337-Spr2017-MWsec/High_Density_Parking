import java.util.ArrayList;

public class mainTester 
{
private static int gridSize = 8;
static parkingGrid p = new parkingGrid(gridSize);
static ArrayList<Location> a = new ArrayList<Location>();

public static void main(String args[])
{
	Location current = new Location(10,5);
	Location desired = new Location(7,3);
	Location blocked = new Location(1,1);
	a = p.HPath(current, desired,blocked);
	printA();
	current = new Location(2,2);
	desired = new Location (5,7);
	a= p.EPath(current, desired);
	printA();
}

public static void printA()
{
	for(int i =0; i<a.size(); i++)
	{
		System.out.print( a.get(i) );
	}
	System.out.println();
}

}