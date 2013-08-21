
public class FordFactory extends AbstractFactory
{
	public SportsCarIF getSportsCar()
	{
		return new FordMustang();
	}

	public EconomyCarIF getEconomyCar()
	{
		return new FordFocus();
	}
}
