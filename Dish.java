
public class Dish 
{
	int worms;
	int copy;
	public Dish (int worms)
	{
		this.worms = worms;
		copy = worms;
	}
	public synchronized void eat ()
	{
		if (worms <= 0)
		{

			waitForFull();
		}
		worms --;
		System.out.println("Bird " + Thread.currentThread().getName() + " has eaten."
							+ " The number of worms left is " + worms);
		
	}
	public synchronized void fill()
	{
		if (worms > 0)
		{
			waitForEmpty();
		}
		worms = copy;
		System.out.println ("Parent filled the dish");
		notifyAll();
	}
	public synchronized void waitForEmpty ()
	{
		while (worms > 0)
		{
			notifyAll();
			try {wait();}
			catch (Exception ie) {System.out.println (ie.getMessage());}
		}
	}
	public synchronized void waitForFull ()
	{
		while (worms <= 0)
		{
			notifyAll();
			try {wait();}
			catch (Exception ie) {System.out.println (ie.getMessage());}
		}
	}
}
