
public class Leaf extends Component 
{
	public Leaf(String name)
	{
		super(name);
	}
	
	public void rysuj(int ile)
	{
		for(int i=1; i<ile; i++)
			System.out.print("   ");
			
		System.out.println(this.name);
	}

}
