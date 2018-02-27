
public class Child extends Thread
{
	private Dish dish;
	public Child (Dish dish)
	{
		this.dish = dish;
	}
	public void run ()
	{
		while (true)
		{
			int n = Parent.getDone();
			if (n == 0) 
			{
				dish.eat();
				try {sleep(100);}
				catch (Exception ie) {System.out.println (ie.getMessage());}
			}
			else 
			{
				//notifyAll();
				break;
			}
		}
	}
}
