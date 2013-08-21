import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class WczytywanieTabeli 
{
	private BufferedReader lnr;
	
	WczytywanieTabeli(Reader r)
	{
		this.lnr = new BufferedReader(r);		
	}
	
	public List<Rekord> wczytajOsoby() throws IOException
	{
		String pomocniczyWiersz = lnr.readLine();
		ArrayList<String> listaKluczy = new ArrayList<String>(Arrays.asList(pomocniczyWiersz.split(",")));
		ArrayList<Rekord> listaRekordow = new ArrayList<Rekord>();
		ArrayList<String> wartosciDlaKluczy = new ArrayList<String>();
		
		while( (pomocniczyWiersz = lnr.readLine()) != null)
		{
			wartosciDlaKluczy.addAll(Arrays.asList(pomocniczyWiersz.split(",")));
			Rekord pojedynczyRekord = new Rekord();
			int indeks =0;
			for(String k: listaKluczy)
			{
				pojedynczyRekord.add(k, wartosciDlaKluczy.get(indeks));
				indeks++;
			}
			wartosciDlaKluczy.clear();
			listaRekordow.add(pojedynczyRekord);
		}
		return listaRekordow;
	}
	
}