
public class zestaw2zadanie1main 
{
	public static void main(String[] args) 
	{
	    AbstractFactory honda = AbstractFactory.getFactory("HondaFactory");
	    AbstractFactory ford = AbstractFactory.getFactory("FordFactory");
	    
	    
	    EconomyCarIF autko1 = honda.getEconomyCar(); 
		autko1.driveSlow();		
		
	    EconomyCarIF autko2 = ford.getEconomyCar();
		autko2.driveSlow();
		
	    SportsCarIF autko3 = honda.getSportsCar();
		autko3.driveFast();
		
	    SportsCarIF autko4 = ford.getSportsCar();
		autko4.driveFast();
		
	}
}
