
public class Child extends Thread
{
	private Dish dish;
	public Child (Dish dish)
	{
		this.dish = dish;
	}
	public void run ()
	{
		while (!dish.isTerminated())
		{
			dish.waitForFullToEat();
			try {sleep(100);}
			catch (Exception ie) {System.out.println (ie.getMessage());}
		}
	}
}
