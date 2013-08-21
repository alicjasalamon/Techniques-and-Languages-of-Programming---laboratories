
public class HondaFactory extends AbstractFactory
{
	public SportsCarIF getSportsCar()
	{	
		return new HondaS2000();
	}
	
	public EconomyCarIF getEconomyCar()
	{
		return new HondaCivic();
	}

}
