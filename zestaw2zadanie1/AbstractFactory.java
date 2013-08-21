public abstract class AbstractFactory 
{
	public abstract EconomyCarIF getEconomyCar();
	public abstract SportsCarIF getSportsCar();

	public static AbstractFactory getFactory(String className)
	{
	    /*if(type.equals("Honda"))
			return new HondaFactory();
		
		if(type.equals("Ford"))
			return new FordFactory();

		return new FordFactory();*/
	    try 
	    {
		Class klazz = Class.forName(className);
		return (AbstractFactory)klazz.newInstance();
	    } 
	    catch (Exception e) 
	    {
		e.printStackTrace();
		
	    }
	    return null;
	}
}
