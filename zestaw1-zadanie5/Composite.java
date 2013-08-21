import java.util.ArrayList;
import java.util.List;

public class Composite extends Component
{
	List<Component> elementy = new ArrayList<Component>();
		
	public Composite (String name)
	{
		super(name);
	}
         
        public void rysuj(int ile)
        {
        	for(int i=1; i<ile; i++)
        		System.out.print("   ");
        	    System.out.println("<" + this.name + ">");
			
        	for(Component elem: elementy)
        		elem.rysuj(ile + 2);
        	
        	for(int i=1; i<ile; i++)
        		System.out.print("   ");
        	System.out.println("</" + this.name + ">");
        }
         
        public void dodaj(Component elem)
        {
            elementy.add(elem);
        }
 
        public void usun(Component elem)
        {
            elementy.remove(elem);
        }
}
