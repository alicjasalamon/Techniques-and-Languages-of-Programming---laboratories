import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListaDoSerializacji implements Serializable
{
	List<KlasaDoSerializacji> lista = new ArrayList<KlasaDoSerializacji>();
	
	public void dodaj(KlasaDoSerializacji elem)
    {
        lista.add(elem);
    }

	public void wyswietlaj()
	{
		for(KlasaDoSerializacji elem: lista)
    		System.out.println(elem.getName());
	}
}
