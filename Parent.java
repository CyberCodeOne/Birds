
public class Parent extends Thread
{
	static int done = 0;
	private Dish dish;
	public Parent (Dish dish)
	{
		this.dish = dish;
	}
	
	public void run ()
	{
		for (int i = 0; i < 3; i++)
		{
			dish.waitForEmpty();
			dish.fill();
		}
		done = 1;
	}
	public static synchronized int getDone()
	{
		return done;
	}
}
