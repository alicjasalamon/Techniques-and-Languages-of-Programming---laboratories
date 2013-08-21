import java.util.ArrayList;
import java.util.List;


public class zestaw3zadanie1main 
{
	public static void main(String[] args)
	{
		List<ElementListy> lista1 = new ArrayList<ElementListy>();
		
		lista1.add(new ElementListy("aa"));
		lista1.add(new ElementListy("bb"));
		lista1.add(new ElementListy("cc"));
	
		IteratorIF it =  new ConcreateIterator(lista1);
	
		while(it.hasNext())
		{
		    System.out.println(((ElementListy) it.next()).getName());
		}
	}
}
