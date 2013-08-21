
public class zestaw2zadanie1main 
{
	public static void main(String[] args) 
	{
		EconomyCarIF autko1 = AbstractFactory.getFactory("Honda").getEconomyCar();
		autko1.driveSlow();		
		
		EconomyCarIF autko2 = AbstractFactory.getFactory("Ford").getEconomyCar();
		autko2.driveSlow();
		
		SportsCarIF autko3 = AbstractFactory.getFactory("Honda").getSportsCar();
		autko3.driveFast();
		
		SportsCarIF autko4 = AbstractFactory.getFactory("Ford").getSportsCar();
		autko4.driveFast();
		
	}
}
