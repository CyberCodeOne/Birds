
public class BoundedBuffer 
{
	public BoundedBuffer ()
	{
		int numWorms = 10;
		int numBirds = 5;
		
		Dish dish = new Dish (numWorms);
		Parent parent = new Parent(dish);
		parent.start();
		Child child[] = new Child[numBirds];
		for (int i = 0; i < numBirds; i++)
		{
			child[i] = new Child (dish);
			child[i].start();
		}		
		for (int i = 0; i < numBirds; i++)
		{
			try {child[i].join();}
			catch (Exception ie) {System.out.println (ie.getMessage());}
		}
		
		System.out.println("bids done eating :D");
	}
}
