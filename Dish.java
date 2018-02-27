
public class Dish 
{
	int worms;
	int copy;
	boolean shutDown;
	boolean isTerminated;
	public Dish (int worms)
	{
		this.worms = worms;
		copy = worms;
	}
	public synchronized void waitForEmptyToFill() 
	{
        while (worms > 0) 
        {
            try 
            {
                notifyAll();
                wait();
            } 
            catch (Exception ie) {System.out.println (ie.getMessage());}
        }
        worms = copy;
        System.out.println ("Parent filled the dish");
        notifyAll();
    }

    public synchronized void waitForFullToEat () 
    {
        while (worms <= 0 && !isTerminated()) 
        {
            try 
            {
                notifyAll();
                wait();
            } 
            catch (Exception ie) {System.out.println (ie.getMessage());}
        }
        if (worms > 0) 
        {
            worms--;
            System.out.println("Bird " + Thread.currentThread().getName() + " has eaten."
                    + " The number of worms left is " + worms);
            if (worms == 0 && isShutDown()) {
                setTerminated(true);
                notifyAll();
            }
        }
    }


    public synchronized boolean isShutDown() 
    {
        return shutDown;
    }

    public synchronized void setShutDown(boolean shutDown) 
    {
        this.shutDown = shutDown;
    }

    public synchronized boolean isTerminated() 
    {
        return isTerminated;
    }

    public synchronized void setTerminated(boolean terminated) 
    {
        isTerminated = terminated;
    }
}