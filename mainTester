import java.util.ArrayList;

private static final int total = 4;
private ArrayList <Vehicle>carArray;

this.carArray = new ArrayList<Vehicle>(total);

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

public static void parkedVehicle(){
	 

	for(vehicle: this.carArray){
	vehicle.printDetails();
	System.out.println("++++++ \n");
	 
	}
public static void printA()
{
	for(int i =0; i<a.size(); i++)
	{
		System.out.print( a.get(i) );
	}
	System.out.println();
}

public int numOfAvailableSpots(){
return this.max- this.carArray.size();
}
 
// Method to find number of occupied spaces in the carpark
public int numOfOccupiedSpots(){
return this.carArray.size();

}
