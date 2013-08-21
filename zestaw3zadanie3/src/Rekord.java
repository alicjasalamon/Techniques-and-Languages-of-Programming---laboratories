import java.util.HashMap;

public class Rekord
{
	private HashMap<String,String> pojedynczaOsoba = new HashMap<String,String>();
	
	public void add(String kategoria, String wartosc)
	{
		pojedynczaOsoba.put(kategoria, wartosc);
	}
	
	public String wczytajWartoscDlaKLucza(String klucz)
	{
		return pojedynczaOsoba.get(klucz);
	}
}