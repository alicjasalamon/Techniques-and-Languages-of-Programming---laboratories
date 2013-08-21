public abstract class AbstractFactory 
{
	public abstract EconomyCarIF getEconomyCar();
	public abstract SportsCarIF getSportsCar();

	public static AbstractFactory getFactory(String type)
	{
		if(type.equals("Honda"))
			return new HondaFactory();
		
		if(type.equals("Ford"))
			return new FordFactory();

		return new FordFactory();
	}
}